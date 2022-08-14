package grpc.smartsafety;


import java.io.IOException;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.smartsafety.smartSafetyGrpc.smartSafetyImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class smartSafetyServer extends smartSafetyImplBase{
	
	private Server server;
	private static final Logger logger = Logger.getLogger(smartSafetyServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
		
		smartSafetyServer service = new smartSafetyServer();
		service.registerService();
		service.start();

	}
	
	//Register service withJMDNS
	public void registerService() {
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_smartSafetyServer._tcp.local.";
	            String service_name = "smart Safety Server";
	            int service_port = 50061;
	            String service_description = "Perform safety operations";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
	            
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	   
	}

	private void start() throws IOException, InterruptedException {
		System.out.println("Starting new GRPC server");
		
		int port = 50061;
		//adding smartSafety to server
		server = ServerBuilder.forPort(port).addService(new smartSafetyServer()).build().start();
		 logger.info("Server started, listening on " + port);

		
		// Server will be running until externally terminated.
		 //time out cancellation handling error
	    Runtime.getRuntime().addShutdownHook(new Thread() {
	    	@Override public void run() 
	    	{ System.err.println("Shutting down gRPC server"); 
	    	try { server.shutdown().awaitTermination(30,TimeUnit.SECONDS); 
	    	} catch (InterruptedException e) { e.printStackTrace(System.err); 
	    	} 
	    	} 
	    	}); 
	    }
	   	

		//smart lock RPC
		@Override
		public void smartLock(lockRequest request, StreamObserver<lockResponse> responseObserver)
		{
			String lock = request.getLock();
			System.out.println("Lock is " + lock);		
			
			//return service or response
			lockResponse.Builder responseBuilder = lockResponse.newBuilder();
			responseBuilder.setUnlock(lock);
         
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();	
			
		}
		
		//smart light RPC
		@Override
		public void smartLight(lightRequest request, StreamObserver<lightResponse> responseObserver) {
			String lightOn = request.getLightOn();
			System.out.println("light on is " + lightOn);
			
			lightResponse.Builder responseBuilder = lightResponse.newBuilder();
			responseBuilder.setLightOff(lightOn);
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();				
		}
			
		
	}
	


