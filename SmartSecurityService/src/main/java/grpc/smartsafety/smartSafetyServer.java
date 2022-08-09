package grpc.smartsafety;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;


import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.smartsafety.smartSafetyGrpc.smartSafetyImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class smartSafetyServer {
	
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		smartSafetyServer service = new smartSafetyServer();
		
		service.registerService();
		
		service.start();

	}
	
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

	private void start() throws IOException, InterruptedException {
		System.out.println("Starting new GRPC server");
		
		int port = 50061;
		//smartSafety
		server = ServerBuilder.forPort(port).addService(new SmartSafetyImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	static class SmartSafetyImpl extends smartSafetyImplBase{
		
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
		
		public void smartLight(lightRequest request, StreamObserver<lightResponse> responseObserver) {
			String lightOn = request.getLightOn();
			System.out.println("light on is " + lightOn);
			
			lightResponse.Builder responseBuilder = lightResponse.newBuilder();
			responseBuilder.setLightOff(lightOn);
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();				
		}
		
	
		
		
	}
	

}
