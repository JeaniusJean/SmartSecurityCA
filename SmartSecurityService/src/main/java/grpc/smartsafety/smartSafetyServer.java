package grpc.smartsafety;

import java.io.IOException;

import grpc.smartsafety.smartSafetyGrpc.smartSafetyImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class smartSafetyServer {
	
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		smartSafetyServer service = new smartSafetyServer();
		service.start();

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
