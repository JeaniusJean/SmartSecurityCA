package grpc.smartcameras;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.smartcameras.smartCamerasGrpc.smartCamerasImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class smartCameraServer extends smartCamerasImplBase{
	
	private static final Logger logger = Logger.getLogger(smartCameraServer.class.getName());
	
	 public static void main(String[] args) throws IOException, InterruptedException {
		 
		 
		 smartCameraServer smartcameraserver = new smartCameraServer();
		 smartcameraserver.registerService();
		//create channel from server to channel
		 int port = 50063;
		 
		 Server server = ServerBuilder.forPort(port) 
			        .addService(smartcameraserver) 
			        .build() // Build the server
			        .start();
		 
		 logger.info("Server started, listening on " + port);
		// Server will be running until externally terminated.
		 //  time out cancellation handling error
		 Runtime.getRuntime().addShutdownHook(new Thread() {
		    	@Override public void run() 
		    	{ System.err.println("Shutting down gRPC server"); 
		    	try { server.shutdown().awaitTermination(30,TimeUnit.SECONDS); 
		    	} catch (InterruptedException e) { e.printStackTrace(System.err); 
		    	} 
		    	} 
		    	}); 
	 }
	 
		//dicsover service use jmdns
		private void registerService() {
			 
			try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_smartCameraServer._tcp.local.";
	            String service_name = "smart Camera Server";
	            int service_port = 50063;
	            String service_description = "Perform camera operations";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
	// bi-directional stream
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
			logger.info("Error while reading Smart Camera Stream:" + t);
		}

		@Override
		public void onCompleted() {
			 responseObserver.onCompleted();
		}
		
	};
		
	}
	

	
	// bi-directional stream
	@Override
	public StreamObserver<videoRequest> iPCamera(StreamObserver<videoResponse> responseObserver) {
		return new StreamObserver<videoRequest>() {
			@Override
			public void onNext(videoRequest request) {
				StringBuilder input1 = new StringBuilder(); 
				 input1.append(request.getVideo()); 
		         input1 = input1.reverse();
		      // Preparing and sending the reply for the client.
		            videoResponse reply = videoResponse.newBuilder().setWatchVideo(input1.toString()).build();
		      
		            responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				logger.info("Error while Smart Camera Stream:" + t);
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
			
		};
		
	}

}
		 
		

