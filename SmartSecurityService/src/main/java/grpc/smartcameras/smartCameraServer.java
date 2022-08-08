package grpc.smartcameras;

import java.io.IOException;
import java.util.logging.Logger;


import grpc.smartcameras.smartCamerasGrpc.smartCamerasImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class smartCameraServer extends smartCamerasImplBase{
	
	private static final Logger logger = Logger.getLogger(smartCameraServer.class.getName());
	
	 public static void main(String[] args) throws IOException, InterruptedException {
		 smartCameraServer smartcameraserver = new smartCameraServer();
		 int port = 50063;
		 
		 Server server = ServerBuilder.forPort(port) 
			        .addService(smartcameraserver) 
			        .build() // Build the server
			        .start();
		 
		 logger.info("Server started, listening on " + port);
		 server.awaitTermination();
	 }
	 // bi-directional steam
	  //rpc smartDoorbell (stream ringRequest) returns (stream ringResponse) {}
	  
	 
	@Override
	public StreamObserver<ringRequest> smartDoorbell(StreamObserver<ringResponse> responseObserver) {
		return new StreamObserver<ringRequest>() {
		@Override
		public void onNext(ringRequest request) {
			StringBuilder input1 = new StringBuilder(); 
			 input1.append(request.getRing()); 
	         input1 = input1.reverse();
	      // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
	            ringResponse reply = ringResponse.newBuilder().setRespond(input1.toString()).build();
	      
	            responseObserver.onNext(reply);
			
		}

		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onCompleted() {
			 responseObserver.onCompleted();
			
		}
		
	};
	
	
		
		
	}


	@Override
	public StreamObserver<videoRequest> iPCamera(StreamObserver<videoResponse> responseObserver) {
		return new StreamObserver<videoRequest>() {
			@Override
			public void onNext(videoRequest request) {
				StringBuilder input1 = new StringBuilder(); 
				 input1.append(request.getVideo()); 
		         input1 = input1.reverse();
		      // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
		            videoResponse reply = videoResponse.newBuilder().setWatchVideo(input1.toString()).build();
		      
		            responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
			
		};
		
	}


	
	
	
	 	 
	}
		 
		

