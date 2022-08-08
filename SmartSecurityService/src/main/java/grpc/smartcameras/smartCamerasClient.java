package grpc.smartcameras;


import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
		
		public static void main(String[] args) throws Exception {
			// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50058).
			// As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50063).usePlaintext().build();

			//stubs -- generate from proto
			//blockingStub = smartCamerasGrpc.newBlockingStub(channel);
			asyncStub = smartCamerasGrpc.newStub(channel);

			//bidirectional streaming
			smartDoorbell();
			IPCamera();

			// Closing the channel once message has been passed.		
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

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
			requestObserver.onNext(ringRequest.newBuilder().setRing("my text").build());
			requestObserver.onNext(ringRequest.newBuilder().setRing("document").build());

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

		
		
	


