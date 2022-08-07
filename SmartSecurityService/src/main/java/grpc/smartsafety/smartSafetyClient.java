package grpc.smartsafety;

import java.util.concurrent.TimeUnit;

import grpc.smartsafety.smartSafetyGrpc.smartSafetyBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class smartSafetyClient {

	public static void main(String[] args) throws InterruptedException {
		//build a channel to connect the client to the server
		int port = 50061;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//build message
		lockRequest cString = lockRequest.newBuilder().setLock("test").build();
		
		//create a stub local representation of remote service
		smartSafetyBlockingStub bstub = smartSafetyGrpc.newBlockingStub(newChannel);
				
		lockResponse response = bstub.smartLock(cString);
		
		System.out.println("This is the client: " + response.getUnlock());
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		
	}

}
