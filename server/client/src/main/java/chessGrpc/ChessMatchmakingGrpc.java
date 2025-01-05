package chessGrpc;

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
    comments = "Source: chess.proto")
public final class ChessMatchmakingGrpc {

  private ChessMatchmakingGrpc() {}

  public static final String SERVICE_NAME = "chessGrpc.ChessMatchmaking";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.StartGameRequest,
      chessGrpc.Chess.StartGameResponse> getStartGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartGame",
      requestType = chessGrpc.Chess.StartGameRequest.class,
      responseType = chessGrpc.Chess.StartGameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.StartGameRequest,
      chessGrpc.Chess.StartGameResponse> getStartGameMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.StartGameRequest, chessGrpc.Chess.StartGameResponse> getStartGameMethod;
    if ((getStartGameMethod = ChessMatchmakingGrpc.getStartGameMethod) == null) {
      synchronized (ChessMatchmakingGrpc.class) {
        if ((getStartGameMethod = ChessMatchmakingGrpc.getStartGameMethod) == null) {
          ChessMatchmakingGrpc.getStartGameMethod = getStartGameMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.StartGameRequest, chessGrpc.Chess.StartGameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessMatchmaking", "StartGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.StartGameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.StartGameResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessMatchmakingMethodDescriptorSupplier("StartGame"))
                  .build();
          }
        }
     }
     return getStartGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChessMatchmakingStub newStub(io.grpc.Channel channel) {
    return new ChessMatchmakingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChessMatchmakingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChessMatchmakingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChessMatchmakingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChessMatchmakingFutureStub(channel);
  }

  /**
   */
  public static abstract class ChessMatchmakingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * When clients requests to start a new game
     * </pre>
     */
    public void startGame(chessGrpc.Chess.StartGameRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.StartGameResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStartGameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartGameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.StartGameRequest,
                chessGrpc.Chess.StartGameResponse>(
                  this, METHODID_START_GAME)))
          .build();
    }
  }

  /**
   */
  public static final class ChessMatchmakingStub extends io.grpc.stub.AbstractStub<ChessMatchmakingStub> {
    private ChessMatchmakingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChessMatchmakingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessMatchmakingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChessMatchmakingStub(channel, callOptions);
    }

    /**
     * <pre>
     * When clients requests to start a new game
     * </pre>
     */
    public void startGame(chessGrpc.Chess.StartGameRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.StartGameResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChessMatchmakingBlockingStub extends io.grpc.stub.AbstractStub<ChessMatchmakingBlockingStub> {
    private ChessMatchmakingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChessMatchmakingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessMatchmakingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChessMatchmakingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * When clients requests to start a new game
     * </pre>
     */
    public chessGrpc.Chess.StartGameResponse startGame(chessGrpc.Chess.StartGameRequest request) {
      return blockingUnaryCall(
          getChannel(), getStartGameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChessMatchmakingFutureStub extends io.grpc.stub.AbstractStub<ChessMatchmakingFutureStub> {
    private ChessMatchmakingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChessMatchmakingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessMatchmakingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChessMatchmakingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * When clients requests to start a new game
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.StartGameResponse> startGame(
        chessGrpc.Chess.StartGameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_GAME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChessMatchmakingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChessMatchmakingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_GAME:
          serviceImpl.startGame((chessGrpc.Chess.StartGameRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.StartGameResponse>) responseObserver);
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

  private static abstract class ChessMatchmakingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChessMatchmakingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chessGrpc.Chess.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChessMatchmaking");
    }
  }

  private static final class ChessMatchmakingFileDescriptorSupplier
      extends ChessMatchmakingBaseDescriptorSupplier {
    ChessMatchmakingFileDescriptorSupplier() {}
  }

  private static final class ChessMatchmakingMethodDescriptorSupplier
      extends ChessMatchmakingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChessMatchmakingMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChessMatchmakingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChessMatchmakingFileDescriptorSupplier())
              .addMethod(getStartGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
