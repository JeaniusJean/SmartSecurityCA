package grpc.smartalarms;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


import grpc.smartsafety.smartSafetyClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class smartAlarmsClient {
	
	private static  Logger logger = Logger.getLogger(smartAlarmsClient.class.getName());
	
	private static smartAlarmsGrpc.smartAlarmsBlockingStub blockingStub;
	private static smartAlarmsGrpc.smartAlarmsStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException{
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50062).usePlaintext().build();
	
	blockingStub = smartAlarmsGrpc.newBlockingStub(channel);
	asyncStub = smartAlarmsGrpc.newStub(channel);
	
	
	alarmSystem();
	smokeAlarmAsync();
	smokeAlarmBlocking();
	
	
	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	
			
	}
	

	
	private static void alarmSystem(){
		StreamObserver<sensorResponse> responseObserver = new StreamObserver<sensorResponse>(){
			
			@Override
			public void onNext(sensorResponse value) {
				System.out.println("receiving length: " + value.getSensorAlarm());
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void onCompleted() {
				System.out.println("completed ");

			}
		};
		
		StreamObserver<sensorRequest> requestObserver = asyncStub.alarmSystem(responseObserver);
		try {

			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Ann").build());
			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Paul").build());
			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Maria").build());
			requestObserver.onNext(sensorRequest.newBuilder().setSensor("Nick").build());

			System.out.println("SENDING EMSSAGES");

			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}


	}


		
		
			
	

	private static void smokeAlarmAsync() {
		smokeRequest request = smokeRequest.newBuilder().setSmoke("message 1 - introduction").build();
		
		StreamObserver<smokeResponse> responseObserver = new StreamObserver<smokeResponse>() {
			int count =0 ;

			@Override
			public void onNext(smokeResponse value) {
				System.out.println("receiving messages " + value);
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received "+ count+ " messages");
			}
			
		

		};
			
		asyncStub.smokeAlarm(request, responseObserver);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	

	//blocking server-streaming
	public static void smokeAlarmBlocking() {
		smokeRequest request = smokeRequest.newBuilder().setSmoke("message 1 - introduction").build();
		// as this call is blocking. The client will not proceed until all the messages in stream has been received. 
				try {
					// Iterating each message in response when calling remote split RPC method.
					Iterator<smokeResponse> responces = blockingStub.smokeAlarm(request);
					
					// Client keeps a check on the next message in stream.
					while(responces.hasNext()) {
						smokeResponse temp = responces.next();
						System.out.println(temp.getLongtitude() + temp.getLongtitude());
					}

				} catch (StatusRuntimeException e) {
					e.printStackTrace();
				}
				
			}
		
	}
		
	
	


