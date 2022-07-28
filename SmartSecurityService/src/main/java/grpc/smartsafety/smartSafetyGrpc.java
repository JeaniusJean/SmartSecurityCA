package grpc.smartsafety;

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
    comments = "Source: smartSafety.proto")
public final class smartSafetyGrpc {

  private smartSafetyGrpc() {}

  public static final String SERVICE_NAME = "smartSafety";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.smartsafety.lockRequest,
      grpc.smartsafety.lockResponse> getSmartLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SmartLock",
      requestType = grpc.smartsafety.lockRequest.class,
      responseType = grpc.smartsafety.lockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.smartsafety.lockRequest,
      grpc.smartsafety.lockResponse> getSmartLockMethod() {
    io.grpc.MethodDescriptor<grpc.smartsafety.lockRequest, grpc.smartsafety.lockResponse> getSmartLockMethod;
    if ((getSmartLockMethod = smartSafetyGrpc.getSmartLockMethod) == null) {
      synchronized (smartSafetyGrpc.class) {
        if ((getSmartLockMethod = smartSafetyGrpc.getSmartLockMethod) == null) {
          smartSafetyGrpc.getSmartLockMethod = getSmartLockMethod = 
              io.grpc.MethodDescriptor.<grpc.smartsafety.lockRequest, grpc.smartsafety.lockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartSafety", "SmartLock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartsafety.lockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartsafety.lockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new smartSafetyMethodDescriptorSupplier("SmartLock"))
                  .build();
          }
        }
     }
     return getSmartLockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.smartsafety.lightRequest,
      grpc.smartsafety.lightResponse> getSmartLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SmartLight",
      requestType = grpc.smartsafety.lightRequest.class,
      responseType = grpc.smartsafety.lightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.smartsafety.lightRequest,
      grpc.smartsafety.lightResponse> getSmartLightMethod() {
    io.grpc.MethodDescriptor<grpc.smartsafety.lightRequest, grpc.smartsafety.lightResponse> getSmartLightMethod;
    if ((getSmartLightMethod = smartSafetyGrpc.getSmartLightMethod) == null) {
      synchronized (smartSafetyGrpc.class) {
        if ((getSmartLightMethod = smartSafetyGrpc.getSmartLightMethod) == null) {
          smartSafetyGrpc.getSmartLightMethod = getSmartLightMethod = 
              io.grpc.MethodDescriptor.<grpc.smartsafety.lightRequest, grpc.smartsafety.lightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartSafety", "SmartLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartsafety.lightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartsafety.lightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new smartSafetyMethodDescriptorSupplier("SmartLight"))
                  .build();
          }
        }
     }
     return getSmartLightMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static smartSafetyStub newStub(io.grpc.Channel channel) {
    return new smartSafetyStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static smartSafetyBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new smartSafetyBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static smartSafetyFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new smartSafetyFutureStub(channel);
  }

  /**
   */
  public static abstract class smartSafetyImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void smartLock(grpc.smartsafety.lockRequest request,
        io.grpc.stub.StreamObserver<grpc.smartsafety.lockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSmartLockMethod(), responseObserver);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void smartLight(grpc.smartsafety.lightRequest request,
        io.grpc.stub.StreamObserver<grpc.smartsafety.lightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSmartLightMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmartLockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.smartsafety.lockRequest,
                grpc.smartsafety.lockResponse>(
                  this, METHODID_SMART_LOCK)))
          .addMethod(
            getSmartLightMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.smartsafety.lightRequest,
                grpc.smartsafety.lightResponse>(
                  this, METHODID_SMART_LIGHT)))
          .build();
    }
  }

  /**
   */
  public static final class smartSafetyStub extends io.grpc.stub.AbstractStub<smartSafetyStub> {
    private smartSafetyStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartSafetyStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartSafetyStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartSafetyStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void smartLock(grpc.smartsafety.lockRequest request,
        io.grpc.stub.StreamObserver<grpc.smartsafety.lockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSmartLockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void smartLight(grpc.smartsafety.lightRequest request,
        io.grpc.stub.StreamObserver<grpc.smartsafety.lightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSmartLightMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class smartSafetyBlockingStub extends io.grpc.stub.AbstractStub<smartSafetyBlockingStub> {
    private smartSafetyBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartSafetyBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartSafetyBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartSafetyBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public grpc.smartsafety.lockResponse smartLock(grpc.smartsafety.lockRequest request) {
      return blockingUnaryCall(
          getChannel(), getSmartLockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public grpc.smartsafety.lightResponse smartLight(grpc.smartsafety.lightRequest request) {
      return blockingUnaryCall(
          getChannel(), getSmartLightMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class smartSafetyFutureStub extends io.grpc.stub.AbstractStub<smartSafetyFutureStub> {
    private smartSafetyFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartSafetyFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartSafetyFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartSafetyFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.smartsafety.lockResponse> smartLock(
        grpc.smartsafety.lockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSmartLockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.smartsafety.lightResponse> smartLight(
        grpc.smartsafety.lightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSmartLightMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SMART_LOCK = 0;
  private static final int METHODID_SMART_LIGHT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final smartSafetyImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(smartSafetyImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SMART_LOCK:
          serviceImpl.smartLock((grpc.smartsafety.lockRequest) request,
              (io.grpc.stub.StreamObserver<grpc.smartsafety.lockResponse>) responseObserver);
          break;
        case METHODID_SMART_LIGHT:
          serviceImpl.smartLight((grpc.smartsafety.lightRequest) request,
              (io.grpc.stub.StreamObserver<grpc.smartsafety.lightResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class smartSafetyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    smartSafetyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.smartsafety.SmartSafetyImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("smartSafety");
    }
  }

  private static final class smartSafetyFileDescriptorSupplier
      extends smartSafetyBaseDescriptorSupplier {
    smartSafetyFileDescriptorSupplier() {}
  }

  private static final class smartSafetyMethodDescriptorSupplier
      extends smartSafetyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    smartSafetyMethodDescriptorSupplier(String methodName) {
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
      synchronized (smartSafetyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new smartSafetyFileDescriptorSupplier())
              .addMethod(getSmartLockMethod())
              .addMethod(getSmartLightMethod())
              .build();
        }
      }
    }
    return result;
  }
}
