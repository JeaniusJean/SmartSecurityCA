package grpc.smartsafety;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;



import grpc.smartsafety.smartSafetyGrpc.smartSafetyStub;

//required grpc package for the client side

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class smartSafetyClient {

		// logger to show client side logs in the console
		private static  Logger logger = Logger.getLogger(smartSafetyClient.class.getName());
		// Blocking stub
		private static smartSafetyGrpc.smartSafetyBlockingStub blockingStub;
		private ServiceInfo smartSafetyInfo; 	//register services for automatic discovery.
		
		public static void main(String[] args) throws InterruptedException{
			
			// Discover the jmDNS service
			smartSafetyClient smartSafety = new smartSafetyClient();
			String service_type = "_http._tcp.local.";
			smartSafety.discoverSafety(service_type);
			
			// create channel
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061).usePlaintext().build();

			//stubs
			blockingStub = smartSafetyGrpc.newBlockingStub(channel);

			// Unary RPC call
			smartLock();
			smartLight();

			// Closing the channel once message has been passed.
			System.out.println("shutting down");
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

		}
		
		//unary rpc
		public static void smartLock() {
			// create a message
			lockRequest req = lockRequest.newBuilder().setLock("Locked all doors").build();
			//  Call blocking stub 
			lockResponse response = blockingStub.smartLock(req);

			//print response value
			System.out.println(response.getUnlock());
			
			// setting a deadline
			response = blockingStub.withDeadlineAfter(100, TimeUnit.MILLISECONDS).smartLock(req);
		}
		
		//unary rpc
		public static void  smartLight() {
			lightRequest req = lightRequest.newBuilder().setLightOn("Light turned on").build();
			lightResponse response = blockingStub.smartLight(req);
			System.out.println(response.getLightOff());
			// setting a deadline
			response = blockingStub.withDeadlineAfter(100, TimeUnit.MILLISECONDS).smartLight(req);
			
		}
		
		
		// set discovery for server. Install jmdns
		private void discoverSafety(String service_type) {
		
			try {
				// Create a JmDNS instance
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

					
				jmdns.addServiceListener(service_type, new ServiceListener() {
					
					@Override
					public void serviceResolved(ServiceEvent event) {
						System.out.println("Service resolved: " + event.getInfo());
					
						smartSafetyInfo = event.getInfo();

						int port = smartSafetyInfo.getPort();
						
						System.out.println("resolving " + service_type + " with properties ...");
						System.out.println("\t port: " + port);
						System.out.println("\t type:"+ event.getType());
						System.out.println("\t name: " + event.getName());
						System.out.println("\t description/properties: " + smartSafetyInfo.getNiceTextString());
						//System.out.println("\t host: " + smartSafetyInfo.getHostAddresses()[0]);
					
						
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
}
