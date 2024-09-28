package com.example.grpc.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service interface. Defines request parameters and response results
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: src/proto/clientStreamingRPC.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RPCDateServiceGrpc {

  private RPCDateServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.api.RPCDateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.api.RPCDateRequest,
      com.example.grpc.api.RPCDateResponse> getGetDateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getDate",
      requestType = com.example.grpc.api.RPCDateRequest.class,
      responseType = com.example.grpc.api.RPCDateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.api.RPCDateRequest,
      com.example.grpc.api.RPCDateResponse> getGetDateMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.api.RPCDateRequest, com.example.grpc.api.RPCDateResponse> getGetDateMethod;
    if ((getGetDateMethod = RPCDateServiceGrpc.getGetDateMethod) == null) {
      synchronized (RPCDateServiceGrpc.class) {
        if ((getGetDateMethod = RPCDateServiceGrpc.getGetDateMethod) == null) {
          RPCDateServiceGrpc.getGetDateMethod = getGetDateMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.api.RPCDateRequest, com.example.grpc.api.RPCDateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getDate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.api.RPCDateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.api.RPCDateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RPCDateServiceMethodDescriptorSupplier("getDate"))
              .build();
        }
      }
    }
    return getGetDateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPCDateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceStub>() {
        @java.lang.Override
        public RPCDateServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCDateServiceStub(channel, callOptions);
        }
      };
    return RPCDateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPCDateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceBlockingStub>() {
        @java.lang.Override
        public RPCDateServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCDateServiceBlockingStub(channel, callOptions);
        }
      };
    return RPCDateServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPCDateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceFutureStub>() {
        @java.lang.Override
        public RPCDateServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCDateServiceFutureStub(channel, callOptions);
        }
      };
    return RPCDateServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service interface. Defines request parameters and response results
   * </pre>
   */
  public static abstract class RPCDateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.api.RPCDateRequest> getDate(
        io.grpc.stub.StreamObserver<com.example.grpc.api.RPCDateResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetDateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDateMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.example.grpc.api.RPCDateRequest,
                com.example.grpc.api.RPCDateResponse>(
                  this, METHODID_GET_DATE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service interface. Defines request parameters and response results
   * </pre>
   */
  public static final class RPCDateServiceStub extends io.grpc.stub.AbstractAsyncStub<RPCDateServiceStub> {
    private RPCDateServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCDateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCDateServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.api.RPCDateRequest> getDate(
        io.grpc.stub.StreamObserver<com.example.grpc.api.RPCDateResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGetDateMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service interface. Defines request parameters and response results
   * </pre>
   */
  public static final class RPCDateServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RPCDateServiceBlockingStub> {
    private RPCDateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCDateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCDateServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Service interface. Defines request parameters and response results
   * </pre>
   */
  public static final class RPCDateServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RPCDateServiceFutureStub> {
    private RPCDateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCDateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCDateServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_DATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPCDateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPCDateServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_GET_DATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getDate(
              (io.grpc.stub.StreamObserver<com.example.grpc.api.RPCDateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RPCDateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RPCDateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.api.RPCDateServiceApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RPCDateService");
    }
  }

  private static final class RPCDateServiceFileDescriptorSupplier
      extends RPCDateServiceBaseDescriptorSupplier {
    RPCDateServiceFileDescriptorSupplier() {}
  }

  private static final class RPCDateServiceMethodDescriptorSupplier
      extends RPCDateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RPCDateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RPCDateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RPCDateServiceFileDescriptorSupplier())
              .addMethod(getGetDateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
