package grpc.smartalarms;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.ForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.stub.StreamObserver;

public class smartAlarmsClient {

	private static Logger logger = Logger.getLogger(smartAlarmsClient.class.getName());
	private static smartAlarmsGrpc.smartAlarmsStub asyncStub;
	private static smartAlarmsGrpc.smartAlarmsStub blockingStub;
	private ServiceInfo smartAlarmsInfo;

	//// client sends meta data
	static class smartAlarmsInterceptor implements ClientInterceptor {

		@Override
		public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
				CallOptions callOptions, Channel next) {
			return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
				@Override
				public void start(Listener<RespT> responseListener, Metadata headers) {
					logger.info("Added metadata");
					headers.put(Metadata.Key.of("HOSTNAME", ASCII_STRING_MARSHALLER), "MY_HOST");
					super.start(responseListener, headers);
				}
			};
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// Discover the jmDNS service
		smartAlarmsClient smartAlarms = new smartAlarmsClient();
		String service_type = "_http._tcp.local.";
		smartAlarms.discoverAlarms(service_type);

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50062).usePlaintext().build();

		asyncStub = smartAlarmsGrpc.newStub(channel);
		blockingStub = smartAlarmsGrpc.newStub(channel);

		alarmSystem();
		smokeAlarm();

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	//discover service
	private void discoverAlarms(String service_type) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Service resolved: " + event.getInfo());

					smartAlarmsInfo = event.getInfo();

					int port = smartAlarmsInfo.getPort();

					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:" + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + smartAlarmsInfo.getNiceTextString());
		

				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Service removed: " + event.getInfo());

				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Service added: " + event.getInfo());

				}
			});
			Thread.sleep(2000);

			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void alarmSystem() {
		StreamObserver<sensorResponse> responseObserver = new StreamObserver<sensorResponse>() {

			@Override
			public void onNext(sensorResponse value) {
				System.out.println("receiving length: " + value.getSensorAlarm());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				System.out.println("completed ");

			}
		};

		StreamObserver<sensorRequest> requestObserver = asyncStub.alarmSystem(responseObserver);
		try {

			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Ann").build());
			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Paul").build());
			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Maria").build());
			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Nick").build());

			System.out.println("SENDING MESSAGES");

			// Mark the end of requests
			requestObserver.onCompleted();

			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// server stream using Asnyc stub

	private static void smokeAlarm() {
		smokeRequest request = smokeRequest.newBuilder().setSmoke("message 1 - introduction").build();

		StreamObserver<smokeResponse> responseObserver = new StreamObserver<smokeResponse>() {
			int count = 0;

			@Override
			public void onNext(smokeResponse value) {
				System.out.println("receiving messages " + value);
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received " + count + " messages");
			}

		};

		asyncStub.smokeAlarm(request, responseObserver);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public class Constants {
	    public static final String JWT_SIGNING_KEY = "L8hHXsaQOUjk5rg7XPGv4eL36anlCrkMz8CJ0i/8E/0=";
	    public static final String BEARER_TYPE = "Bearer";

	    public final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER);
	    public final Context.Key<String> CLIENT_ID_CONTEXT_KEY = Context.key("clientId");

	    private Constants() {
	        throw new AssertionError();
	    }
	}

}
