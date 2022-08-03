package grpc.smartalarms;
import java.io.IOException;
import java.util.logging.Logger;


import grpc.smartalarms.smartAlarmsGrpc.smartAlarmsImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/*server stream
	rpc smokeAlarm (smokeRequest) returns (stream smokeResponse) {}

	//client stream
	rpc alarmSystem (stream sensorRequest)returns (sensorResponse) {}
*/

public class smartAlarmsServer extends smartAlarmsImplBase {
	
	private static final Logger logger = Logger.getLogger(smartAlarmsServer.class.getName());
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		smartAlarmsServer service = new smartAlarmsServer();
		
		 int port = 50052;
		    
		   

		    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
		        .addService(service) // Service is defined in line 31
		        .build() // Build the server
		        .start(); // Start the server and keep it running for clients to contact.
		    
		    // Giving a logging information on the server console that server has started
		    logger.info("Server started, listening on " + port);
		    		    
		    // Server will be running until externally terminated.
		    server.awaitTermination();
		

}	
	@Override
	public void smokeAlarm(smokeRequest request, StreamObserver<smokeResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.smokeAlarm(request, responseObserver);
	
		 System.out.println("receiving smokeAlarm");
		 
		 int length = request.getSmoke().length();
			
			//preparing the response message
		 	smokeResponse reply = smokeResponse.newBuilder().setLatitude(length).setLongtitude(length).build();
		

			responseObserver.onNext( reply ); 
			

			responseObserver.onCompleted();

		}
	
	
	@Override
	public StreamObserver<sensorRequest> alarmSystem(StreamObserver<sensorResponse> responseObserver) {
		return new StreamObserver<sensorRequest>() {
			
			int length = 0;
			
			// For each message in the stream, get one stream at a time.
			// NOTE: YOU MAY MODIFY THE LOGIC OF onNext, onError, onCompleted BASED ON YOUR PROJECT.
			@Override
			public void onNext(sensorRequest value) {
				// Here, in this example we compute the value of string length for each message in the stream. 
				System.out.println("receive -> " + value.getSensor());
				// Keep on adding all the length values to compute the total length of strings sent by the client in the stream 
				length += value.getSensor().length();
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			// Once the complete stream is received this logic will be executed.
			@Override
			public void onCompleted() {
				// Preparing and sending the reply for the client. Here, response is build and with the value (length) computed by above logic.
				 // Here, response is sent once the client is done with sending the stream.
				sensorResponse res = sensorResponse.newBuilder().build();
		          responseObserver.onNext(res);
		          responseObserver.onCompleted();
			}

			
			
			
		};
	}

	
	}
	 
	 

	

