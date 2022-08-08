package grpc.smartsafety;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import grpc.smartsafety.smartSafetyGrpc.smartSafetyStub;

//required grpc package for the client side

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class smartSafetyClient {

	
		// First we create a logger to show client side logs in the console. logger instance will be used to log different events at the client console.
		// This is optional. Could be used if needed.
		private static  Logger logger = Logger.getLogger(smartSafetyClient.class.getName());

		// Creating stubs for establishing the connection with server.
		// Blocking stub
		private static smartSafetyGrpc.smartSafetyBlockingStub blockingStub;
		// Async stub
		private static smartSafetyStub asyncStub;
		
		// The main method will have the logic for client.
		public static void main(String[] args) throws InterruptedException{
		// First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50055).
			// As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061).usePlaintext().build();

			//stubs -- generate from proto
			blockingStub = smartSafetyGrpc.newBlockingStub(channel);
			asyncStub = smartSafetyGrpc.newStub(channel);

			// Unary RPC call
			smartLock();
			smartLight();
			

			// Closing the channel once message has been passed.
			System.out.println("shutting down");
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

		}
		
		//unary rpc
		public static void smartLock() {
			// First creating a request message. Here, the message contains a string in setVal
			lockRequest req = lockRequest.newBuilder().setLock("Hello lock").build();
			//  Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
			lockResponse response = blockingStub.smartLock(req);

			//response contains the output from the server side. Here, we are printing the value contained by response. 
			System.out.println(response.getUnlock());
		}
		
		public static void  smartLight() {
			lightRequest req = lightRequest.newBuilder().setLightOn("Hello light").build();
			lightResponse response = blockingStub.smartLight(req);
			System.out.println(response.getLightOff());
			
		}
		


}
