package grpc.smartcameras;

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
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smartCameras.proto")
public final class smartCamerasGrpc {

  private smartCamerasGrpc() {}

  public static final String SERVICE_NAME = "smartCameras";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.smartcameras.ringRequest,
      grpc.smartcameras.ringResponse> getSmartDoorbellMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "smartDoorbell",
      requestType = grpc.smartcameras.ringRequest.class,
      responseType = grpc.smartcameras.ringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.smartcameras.ringRequest,
      grpc.smartcameras.ringResponse> getSmartDoorbellMethod() {
    io.grpc.MethodDescriptor<grpc.smartcameras.ringRequest, grpc.smartcameras.ringResponse> getSmartDoorbellMethod;
    if ((getSmartDoorbellMethod = smartCamerasGrpc.getSmartDoorbellMethod) == null) {
      synchronized (smartCamerasGrpc.class) {
        if ((getSmartDoorbellMethod = smartCamerasGrpc.getSmartDoorbellMethod) == null) {
          smartCamerasGrpc.getSmartDoorbellMethod = getSmartDoorbellMethod = 
              io.grpc.MethodDescriptor.<grpc.smartcameras.ringRequest, grpc.smartcameras.ringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartCameras", "smartDoorbell"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartcameras.ringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartcameras.ringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new smartCamerasMethodDescriptorSupplier("smartDoorbell"))
                  .build();
          }
        }
     }
     return getSmartDoorbellMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.smartcameras.videoRequest,
      grpc.smartcameras.videoResponse> getIPCameraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IPCamera",
      requestType = grpc.smartcameras.videoRequest.class,
      responseType = grpc.smartcameras.videoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.smartcameras.videoRequest,
      grpc.smartcameras.videoResponse> getIPCameraMethod() {
    io.grpc.MethodDescriptor<grpc.smartcameras.videoRequest, grpc.smartcameras.videoResponse> getIPCameraMethod;
    if ((getIPCameraMethod = smartCamerasGrpc.getIPCameraMethod) == null) {
      synchronized (smartCamerasGrpc.class) {
        if ((getIPCameraMethod = smartCamerasGrpc.getIPCameraMethod) == null) {
          smartCamerasGrpc.getIPCameraMethod = getIPCameraMethod = 
              io.grpc.MethodDescriptor.<grpc.smartcameras.videoRequest, grpc.smartcameras.videoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartCameras", "IPCamera"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartcameras.videoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.smartcameras.videoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new smartCamerasMethodDescriptorSupplier("IPCamera"))
                  .build();
          }
        }
     }
     return getIPCameraMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static smartCamerasStub newStub(io.grpc.Channel channel) {
    return new smartCamerasStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static smartCamerasBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new smartCamerasBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static smartCamerasFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new smartCamerasFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class smartCamerasImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * bi-directional steam
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.smartcameras.ringRequest> smartDoorbell(
        io.grpc.stub.StreamObserver<grpc.smartcameras.ringResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSmartDoorbellMethod(), responseObserver);
    }

    /**
     * <pre>
     *server stream
     * </pre>
     */
    public void iPCamera(grpc.smartcameras.videoRequest request,
        io.grpc.stub.StreamObserver<grpc.smartcameras.videoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIPCameraMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmartDoorbellMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.smartcameras.ringRequest,
                grpc.smartcameras.ringResponse>(
                  this, METHODID_SMART_DOORBELL)))
          .addMethod(
            getIPCameraMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.smartcameras.videoRequest,
                grpc.smartcameras.videoResponse>(
                  this, METHODID_IPCAMERA)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class smartCamerasStub extends io.grpc.stub.AbstractStub<smartCamerasStub> {
    private smartCamerasStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartCamerasStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartCamerasStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartCamerasStub(channel, callOptions);
    }

    /**
     * <pre>
     * bi-directional steam
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.smartcameras.ringRequest> smartDoorbell(
        io.grpc.stub.StreamObserver<grpc.smartcameras.ringResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSmartDoorbellMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *server stream
     * </pre>
     */
    public void iPCamera(grpc.smartcameras.videoRequest request,
        io.grpc.stub.StreamObserver<grpc.smartcameras.videoResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getIPCameraMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class smartCamerasBlockingStub extends io.grpc.stub.AbstractStub<smartCamerasBlockingStub> {
    private smartCamerasBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartCamerasBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartCamerasBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartCamerasBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *server stream
     * </pre>
     */
    public java.util.Iterator<grpc.smartcameras.videoResponse> iPCamera(
        grpc.smartcameras.videoRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getIPCameraMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class smartCamerasFutureStub extends io.grpc.stub.AbstractStub<smartCamerasFutureStub> {
    private smartCamerasFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private smartCamerasFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected smartCamerasFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new smartCamerasFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_IPCAMERA = 0;
  private static final int METHODID_SMART_DOORBELL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final smartCamerasImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(smartCamerasImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_IPCAMERA:
          serviceImpl.iPCamera((grpc.smartcameras.videoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.smartcameras.videoResponse>) responseObserver);
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
        case METHODID_SMART_DOORBELL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.smartDoorbell(
              (io.grpc.stub.StreamObserver<grpc.smartcameras.ringResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class smartCamerasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    smartCamerasBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.smartcameras.SmartCamerasImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("smartCameras");
    }
  }

  private static final class smartCamerasFileDescriptorSupplier
      extends smartCamerasBaseDescriptorSupplier {
    smartCamerasFileDescriptorSupplier() {}
  }

  private static final class smartCamerasMethodDescriptorSupplier
      extends smartCamerasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    smartCamerasMethodDescriptorSupplier(String methodName) {
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
      synchronized (smartCamerasGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new smartCamerasFileDescriptorSupplier())
              .addMethod(getSmartDoorbellMethod())
              .addMethod(getIPCameraMethod())
              .build();
        }
      }
    }
    return result;
  }
}
