package grpc.smartalarms;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

import grpc.smartalarms.smartAlarmsGrpc.smartAlarmsImplBase;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class smartAlarmsServer extends smartAlarmsImplBase {

	private static final Logger logger = Logger.getLogger(smartAlarmsServer.class.getName());

	// server reads metadata
	class smartAlarmsServerInterceptor implements ServerInterceptor {
		@Override
		public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
				ServerCallHandler<ReqT, RespT> next) {
			logger.info("Recieved following metadata: " + headers);
			return next.startCall(call, headers);
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		smartAlarmsServer service = new smartAlarmsServer();
		service.registerService();

		int port = 50062;

		Server server = ServerBuilder.forPort(port) 
				.addService(service)
				.build() 
				.start();

		// Giving a logging information on the server console that server has started

		logger.info("Server started, listening on " + port);
		// Server will be running until externally terminated.
		// time out cancellation handling error
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("Shutting down gRPC server");
				try {
					server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace(System.err);
				}
			}
		});
	}

	private void registerService() {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			String service_type = "_smartAlarmsServer._tcp.local.";
			String service_name = "smart Alarms Server";
			int service_port = 50062;
			String service_description = "Perform safety operations";

			// Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
			jmdns.registerService(serviceInfo);

			System.out.printf("registering service with type %s and name %s \n", service_type, service_name);

			Thread.sleep(1000);

			// Unregister all services

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void smokeAlarm(smokeRequest request, StreamObserver<smokeResponse> responseObserver) {
		
		super.smokeAlarm(request, responseObserver);
		
		System.out.println("receiving smokeAlarm");
		int length = request.getSmoke().length();
		
		if(length < 0){
            Status status = Status.FAILED_PRECONDITION.withDescription("Not less than 0");
            responseObserver.onError(status.asRuntimeException());
            return;
        }

		// preparing the response message
		smokeResponse reply = smokeResponse.newBuilder().setLatitude(length).setLongtitude(length).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();

	}

	@Override
	public StreamObserver<sensorRequest> alarmSystem(StreamObserver<sensorResponse> responseObserver) {
		return new StreamObserver<sensorRequest>() {

			int length = 0;

			@Override
			public void onNext(sensorRequest value) {

				System.out.println("receive -> " + value.getSensor());

				length += value.getSensor().length();

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {

				sensorResponse res = sensorResponse.newBuilder().build();
				responseObserver.onNext(res);
				responseObserver.onCompleted();
			}

		};
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

