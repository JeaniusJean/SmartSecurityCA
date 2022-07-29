package grpc.smartalarms;
import java.io.IOException;
import java.util.logging.Logger;


import grpc.smartalarms.smartAlarmsGrpc.smartAlarmsImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;



public class smartAlarmsServer extends smartAlarmsImplBase {
	
	private static final Logger logger = Logger.getLogger(smartAlarmsServer.class.getName());
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		smartAlarmsServer service = new smartAlarmsServer();
		
		 int port = 50056;
		    
		   

		    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
		        .addService(service) // Service is defined in line 31
		        .build() // Build the server
		        .start(); // Start the server and keep it running for clients to contact.
		    
		    // Giving a logging information on the server console that server has started
		    logger.info("Server started, listening on " + port);
		    		    
		    // Server will be running until externally terminated.
		    server.awaitTermination();
		

}	
	//server stream
	 @Override
	 public void smokeAlarm (smokeRequest request, StreamObserver<smokeResponse> responseObserver) {
		 System.out.println("receiving smokeAlarm");
		 
		// Retrieve the value from the request of the client and convert it to array
		 char[]characters = request.getSmoke().toCharArray();
		 
		// LOGIC of THE METHOD 
			// NOTE: YOU MAY NEED TO MODIFY THIS LOGIC HERE.
		 System.out.println(characters.length);
		 
		 for(char c: characters) {			
			// Preparing and sending the reply for the client. Here, response is build and with the value (c) computed by above logic.
			 // Here, a stream of response is sent using the for loop.
			 responseObserver.onNext(smokeResponse.newBuilder().setSmokeDetect(Character.toString(c)).build());
		 }
		 
		 responseObserver.onCompleted();
	}

	
}
