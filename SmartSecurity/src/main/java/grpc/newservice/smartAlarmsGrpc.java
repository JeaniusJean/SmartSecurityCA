package grpc.newservice;

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

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
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

  private static abstract class smartAlarmsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    smartAlarmsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.newservice.smartAlarmsImpl.getDescriptor();
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
              .build();
        }
      }
    }
    return result;
  }
}
