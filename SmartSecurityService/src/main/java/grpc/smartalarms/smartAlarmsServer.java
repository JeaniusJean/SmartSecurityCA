package grpc.smartalarms;
import java.io.IOException;
import java.net.InetAddress;

import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

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
		service.registerService();
		
		 int port = 50062;


		    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
		        .addService(service) // Service is defined in line 31
		        .build() // Build the server
		        .start(); // Start the server and keep it running for clients to contact.
		    
		    // Giving a logging information on the server console that server has started
		    logger.info("Server started, listening on " + port);
		    		    
		    // Server will be running until externally terminated.
		    server.awaitTermination();
		   	

}	

		
	private void registerService() {
		try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            
            String service_type = "_smartAlarmsServer._tcp.local.";
            String service_name = "smart Alarms Server";
            int service_port = 50062;
            String service_description = "Perform Alarms operations";
            
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
			
			
			@Override
			public void onNext(sensorRequest value) {
				
				System.out.println("receive -> " + value.getSensor());
				
				length += value.getSensor().length();
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			
			@Override
			public void onCompleted() {
				
				sensorResponse res = sensorResponse.newBuilder().build();
		          responseObserver.onNext(res);
		          responseObserver.onCompleted();
			}

			
			
			
		};
	}
	
	

	
	}
	 
	 

	

