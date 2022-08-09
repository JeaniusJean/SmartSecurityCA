package grpc.smartcameras;


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


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class smartCamerasClient {

		private static  Logger logger = Logger.getLogger(smartCamerasClient.class.getName());
		//private static smartCamerasGrpc.smartCamerasBlockingStub blockingStub;
		private static smartCamerasGrpc.smartCamerasStub asyncStub;
		private ServiceInfo smartCamerasInfo;
		
		public static void main(String[] args) throws Exception {
			
			// Discover the jmDNS service
			smartCamerasClient smartCamera = new smartCamerasClient();
			String service_type = "_http._tcp.local.";
			smartCamera.discoverCameras(service_type);
			
			//create channel from server to channel
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50063).usePlaintext().build();

			//stubs -- generate from proto
			//blockingStub = smartCamerasGrpc.newBlockingStub(channel);
			asyncStub = smartCamerasGrpc.newStub(channel);

			
			//call rpc method
			smartDoorbell();
			IPCamera();

			// Closing the channel once message has been passed.		
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

		}

		
		private void discoverCameras(String service_type) {
			try {
				// Create a JmDNS instance
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

					
				jmdns.addServiceListener(service_type, new ServiceListener() {
					
					@Override
					public void serviceResolved(ServiceEvent event) {
						System.out.println("Service resolved: " + event.getInfo());

						smartCamerasInfo = event.getInfo();

						int port = smartCamerasInfo.getPort();
						
						System.out.println("resolving " + service_type + " with properties ...");
						System.out.println("\t port: " + port);
						System.out.println("\t type:"+ event.getType());
						System.out.println("\t name: " + event.getName());
						System.out.println("\t description/properties: " + smartCamerasInfo.getNiceTextString());
						//System.out.println("\t host: " + smartCamerasInfo.getHostAddresses()[0]);
					
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
				
				// Wait a bit
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


		private static void smartDoorbell() {
			StreamObserver<ringResponse> responseObserver = new StreamObserver<ringResponse>(){
			@Override
			public void onNext(ringResponse value) {

				System.out.println("revered received is " + value.getRespond());

			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("server completed");
			}


		};
		
		StreamObserver<ringRequest>requestObserver = asyncStub.smartDoorbell(responseObserver);

		try {

			requestObserver.onNext(ringRequest.newBuilder().setRing("This").build());
			requestObserver.onNext(ringRequest.newBuilder().setRing("is").build());
			requestObserver.onNext(ringRequest.newBuilder().setRing("my doorbell").build());
			requestObserver.onNext(ringRequest.newBuilder().setRing("streaming").build());

			System.out.println("SENDING MESSAGES");

			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}


	}


		private static void IPCamera() {
			StreamObserver<videoResponse> responseObserver = new StreamObserver<videoResponse>(){
			
				@Override
				public void onNext(videoResponse value) {

					System.out.println("revered received is " + value.getWatchVideo());

				}
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("server completed");
				}


			};
			
			StreamObserver<videoRequest>requestObserver = asyncStub.iPCamera(responseObserver);

			try {

				requestObserver.onNext(videoRequest.newBuilder().setVideo("This").build());
				requestObserver.onNext(videoRequest.newBuilder().setVideo("is").build());
				requestObserver.onNext(videoRequest.newBuilder().setVideo("my video").build());
				requestObserver.onNext(videoRequest.newBuilder().setVideo("streaming").build());

				System.out.println("SENDING MESSAGES");

				// Mark the end of requests
				requestObserver.onCompleted();


				// Sleep for a bit before sending the next one.
				Thread.sleep(new Random().nextInt(1000) + 500);


			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}


		}
		
		
				
			
}

		
		
	


