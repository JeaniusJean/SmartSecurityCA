package grpc.smartalarms;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smartAlarms.proto")
public final class smartAlarmsGrpc {

  private smartAlarmsGrpc() {}

  public static final String SERVICE_NAME = "smartAlarms";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.smartalarms.smokeRequest,
      grpc.smartalarms.smokeResponse> getSmokeAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smokeAlarm",
      requestType = grpc.smartalarms.smokeRequest.class,
      responseType = grpc.smartalarms.smokeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.smartalarms.smokeRequest,
      grpc.smartalarms.smokeResponse> getSmokeAlarmMethod() {
    io.grpc.MethodDescriptor<grpc.smartalarms.smokeRequest, grpc.smartalarms.smokeResponse> getSmokeAlarmMethod;
    if ((getSmokeAlarmMethod = smartAlarmsGrpc.getSmokeAlarmMethod) == null) {
      synchronized (smartAlarmsGrpc.class) {
        if ((getSmokeAlarmMethod = smartAlarmsGrpc.getSmokeAlarmMethod) == null) {
          smartAlarmsGrpc.getSmokeAlarmMethod = getSmokeAlarmMethod = 
              io.grpc.MethodDescriptor.<grpc.smartalarms.smokeRequest, grpc.smartalarms.smokeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartAlarms", "smokeAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartalarms.smokeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartalarms.smokeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new smartAlarmsMethodDescriptorSupplier("smokeAlarm"))
                  .build();
          }
        }
     }
     return getSmokeAlarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.smartalarms.sensorRequest,
      grpc.smartalarms.sensorResponse> getAlarmSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "alarmSystem",
      requestType = grpc.smartalarms.sensorRequest.class,
      responseType = grpc.smartalarms.sensorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.smartalarms.sensorRequest,
      grpc.smartalarms.sensorResponse> getAlarmSystemMethod() {
    io.grpc.MethodDescriptor<grpc.smartalarms.sensorRequest, grpc.smartalarms.sensorResponse> getAlarmSystemMethod;
    if ((getAlarmSystemMethod = smartAlarmsGrpc.getAlarmSystemMethod) == null) {
      synchronized (smartAlarmsGrpc.class) {
        if ((getAlarmSystemMethod = smartAlarmsGrpc.getAlarmSystemMethod) == null) {
          smartAlarmsGrpc.getAlarmSystemMethod = getAlarmSystemMethod = 
              io.grpc.MethodDescriptor.<grpc.smartalarms.sensorRequest, grpc.smartalarms.sensorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartAlarms", "alarmSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartalarms.sensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartalarms.sensorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new smartAlarmsMethodDescriptorSupplier("alarmSystem"))
                  .build();
          }
        }
     }
     return getAlarmSystemMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static smartAlarmsStub newStub(io.grpc.Channel channel) {
    return new smartAlarmsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static smartAlarmsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new smartAlarmsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static smartAlarmsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new smartAlarmsFutureStub(channel);
  }

  /**
   */
  public static abstract class smartAlarmsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * server stream
     * </pre>
     */
    public void smokeAlarm(grpc.smartalarms.smokeRequest request,
        io.grpc.stub.StreamObserver<grpc.smartalarms.smokeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSmokeAlarmMethod(), responseObserver);
    }

    /**
     * <pre>
     *client stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.smartalarms.sensorRequest> alarmSystem(
        io.grpc.stub.StreamObserver<grpc.smartalarms.sensorResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAlarmSystemMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmokeAlarmMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.smartalarms.smokeRequest,
                grpc.smartalarms.smokeResponse>(
                  this, METHODID_SMOKE_ALARM)))
          .addMethod(
            getAlarmSystemMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.smartalarms.sensorRequest,
                grpc.smartalarms.sensorResponse>(
                  this, METHODID_ALARM_SYSTEM)))
          .build();
    }
  }

  /**
   */
  public static final class smartAlarmsStub extends io.grpc.stub.AbstractStub<smartAlarmsStub> {
    private smartAlarmsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartAlarmsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartAlarmsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartAlarmsStub(channel, callOptions);
    }

    /**
     * <pre>
     * server stream
     * </pre>
     */
    public void smokeAlarm(grpc.smartalarms.smokeRequest request,
        io.grpc.stub.StreamObserver<grpc.smartalarms.smokeResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSmokeAlarmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.smartalarms.sensorRequest> alarmSystem(
        io.grpc.stub.StreamObserver<grpc.smartalarms.sensorResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAlarmSystemMethod(), getCallOptions()), responseObserver);
    }

	
  }

  /**
   */
  public static final class smartAlarmsBlockingStub extends io.grpc.stub.AbstractStub<smartAlarmsBlockingStub> {
    private smartAlarmsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartAlarmsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartAlarmsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartAlarmsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server stream
     * </pre>
     */
    public java.util.Iterator<grpc.smartalarms.smokeResponse> smokeAlarm(
        grpc.smartalarms.smokeRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSmokeAlarmMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class smartAlarmsFutureStub extends io.grpc.stub.AbstractStub<smartAlarmsFutureStub> {
    private smartAlarmsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartAlarmsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartAlarmsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartAlarmsFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SMOKE_ALARM = 0;
  private static final int METHODID_ALARM_SYSTEM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final smartAlarmsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(smartAlarmsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SMOKE_ALARM:
          serviceImpl.smokeAlarm((grpc.smartalarms.smokeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.smartalarms.smokeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALARM_SYSTEM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.alarmSystem(
              (io.grpc.stub.StreamObserver<grpc.smartalarms.sensorResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class smartAlarmsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    smartAlarmsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.smartalarms.SmartAlarmsImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("smartAlarms");
    }
  }

  private static final class smartAlarmsFileDescriptorSupplier
      extends smartAlarmsBaseDescriptorSupplier {
    smartAlarmsFileDescriptorSupplier() {}
  }

  private static final class smartAlarmsMethodDescriptorSupplier
      extends smartAlarmsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    smartAlarmsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (smartAlarmsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new smartAlarmsFileDescriptorSupplier())
              .addMethod(getSmokeAlarmMethod())
              .addMethod(getAlarmSystemMethod())
              .build();
        }
      }
    }
    return result;
  }
}
