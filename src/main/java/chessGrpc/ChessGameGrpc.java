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
 * <pre>
 * All available ChessServices
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chess.proto")
public final class ChessGameGrpc {

  private ChessGameGrpc() {}

  public static final String SERVICE_NAME = "chessGrpc.ChessGame";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.MakeMoveRequest,
      chessGrpc.Chess.MakeMoveResponse> getMakeMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeMove",
      requestType = chessGrpc.Chess.MakeMoveRequest.class,
      responseType = chessGrpc.Chess.MakeMoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.MakeMoveRequest,
      chessGrpc.Chess.MakeMoveResponse> getMakeMoveMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.MakeMoveRequest, chessGrpc.Chess.MakeMoveResponse> getMakeMoveMethod;
    if ((getMakeMoveMethod = ChessGameGrpc.getMakeMoveMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getMakeMoveMethod = ChessGameGrpc.getMakeMoveMethod) == null) {
          ChessGameGrpc.getMakeMoveMethod = getMakeMoveMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.MakeMoveRequest, chessGrpc.Chess.MakeMoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessGame", "MakeMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.MakeMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.MakeMoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("MakeMove"))
                  .build();
          }
        }
     }
     return getMakeMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.GameStatusRequest,
      chessGrpc.Chess.GameStatusResponse> getGetGameUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGameUpdate",
      requestType = chessGrpc.Chess.GameStatusRequest.class,
      responseType = chessGrpc.Chess.GameStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.GameStatusRequest,
      chessGrpc.Chess.GameStatusResponse> getGetGameUpdateMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.GameStatusRequest, chessGrpc.Chess.GameStatusResponse> getGetGameUpdateMethod;
    if ((getGetGameUpdateMethod = ChessGameGrpc.getGetGameUpdateMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getGetGameUpdateMethod = ChessGameGrpc.getGetGameUpdateMethod) == null) {
          ChessGameGrpc.getGetGameUpdateMethod = getGetGameUpdateMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.GameStatusRequest, chessGrpc.Chess.GameStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessGame", "GetGameUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.GameStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.GameStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("GetGameUpdate"))
                  .build();
          }
        }
     }
     return getGetGameUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.VerifyMoveRequest,
      chessGrpc.Chess.VerifyMoveResponse> getVerifyMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyMove",
      requestType = chessGrpc.Chess.VerifyMoveRequest.class,
      responseType = chessGrpc.Chess.VerifyMoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.VerifyMoveRequest,
      chessGrpc.Chess.VerifyMoveResponse> getVerifyMoveMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.VerifyMoveRequest, chessGrpc.Chess.VerifyMoveResponse> getVerifyMoveMethod;
    if ((getVerifyMoveMethod = ChessGameGrpc.getVerifyMoveMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getVerifyMoveMethod = ChessGameGrpc.getVerifyMoveMethod) == null) {
          ChessGameGrpc.getVerifyMoveMethod = getVerifyMoveMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.VerifyMoveRequest, chessGrpc.Chess.VerifyMoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessGame", "VerifyMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.VerifyMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.VerifyMoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("VerifyMove"))
                  .build();
          }
        }
     }
     return getVerifyMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.GetMoveRequest,
      chessGrpc.Chess.GetMoveResponse> getGetMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMove",
      requestType = chessGrpc.Chess.GetMoveRequest.class,
      responseType = chessGrpc.Chess.GetMoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.GetMoveRequest,
      chessGrpc.Chess.GetMoveResponse> getGetMoveMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.GetMoveRequest, chessGrpc.Chess.GetMoveResponse> getGetMoveMethod;
    if ((getGetMoveMethod = ChessGameGrpc.getGetMoveMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getGetMoveMethod = ChessGameGrpc.getGetMoveMethod) == null) {
          ChessGameGrpc.getGetMoveMethod = getGetMoveMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.GetMoveRequest, chessGrpc.Chess.GetMoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessGame", "GetMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.GetMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.GetMoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("GetMove"))
                  .build();
          }
        }
     }
     return getGetMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.EndGameRequest,
      chessGrpc.Chess.EndGameResponse> getEndGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EndGame",
      requestType = chessGrpc.Chess.EndGameRequest.class,
      responseType = chessGrpc.Chess.EndGameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.EndGameRequest,
      chessGrpc.Chess.EndGameResponse> getEndGameMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.EndGameRequest, chessGrpc.Chess.EndGameResponse> getEndGameMethod;
    if ((getEndGameMethod = ChessGameGrpc.getEndGameMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getEndGameMethod = ChessGameGrpc.getEndGameMethod) == null) {
          ChessGameGrpc.getEndGameMethod = getEndGameMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.EndGameRequest, chessGrpc.Chess.EndGameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessGame", "EndGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.EndGameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.EndGameResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("EndGame"))
                  .build();
          }
        }
     }
     return getEndGameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<chessGrpc.Chess.GetAllMovesRequest,
      chessGrpc.Chess.GetAllMovesResponse> getGetAllMovesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllMoves",
      requestType = chessGrpc.Chess.GetAllMovesRequest.class,
      responseType = chessGrpc.Chess.GetAllMovesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<chessGrpc.Chess.GetAllMovesRequest,
      chessGrpc.Chess.GetAllMovesResponse> getGetAllMovesMethod() {
    io.grpc.MethodDescriptor<chessGrpc.Chess.GetAllMovesRequest, chessGrpc.Chess.GetAllMovesResponse> getGetAllMovesMethod;
    if ((getGetAllMovesMethod = ChessGameGrpc.getGetAllMovesMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getGetAllMovesMethod = ChessGameGrpc.getGetAllMovesMethod) == null) {
          ChessGameGrpc.getGetAllMovesMethod = getGetAllMovesMethod = 
              io.grpc.MethodDescriptor.<chessGrpc.Chess.GetAllMovesRequest, chessGrpc.Chess.GetAllMovesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "chessGrpc.ChessGame", "GetAllMoves"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.GetAllMovesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chessGrpc.Chess.GetAllMovesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("GetAllMoves"))
                  .build();
          }
        }
     }
     return getGetAllMovesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChessGameStub newStub(io.grpc.Channel channel) {
    return new ChessGameStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChessGameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChessGameBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChessGameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChessGameFutureStub(channel);
  }

  /**
   * <pre>
   * All available ChessServices
   * </pre>
   */
  public static abstract class ChessGameImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * When a move is made in the game by the client
     * </pre>
     */
    public void makeMove(chessGrpc.Chess.MakeMoveRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.MakeMoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeMoveMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client asks server if it made a move
     * </pre>
     */
    public void getGameUpdate(chessGrpc.Chess.GameStatusRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.GameStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGameUpdateMethod(), responseObserver);
    }

    /**
     */
    public void verifyMove(chessGrpc.Chess.VerifyMoveRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.VerifyMoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVerifyMoveMethod(), responseObserver);
    }

    /**
     */
    public void getMove(chessGrpc.Chess.GetMoveRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.GetMoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMoveMethod(), responseObserver);
    }

    /**
     */
    public void endGame(chessGrpc.Chess.EndGameRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.EndGameResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEndGameMethod(), responseObserver);
    }

    /**
     */
    public void getAllMoves(chessGrpc.Chess.GetAllMovesRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.GetAllMovesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMovesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakeMoveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.MakeMoveRequest,
                chessGrpc.Chess.MakeMoveResponse>(
                  this, METHODID_MAKE_MOVE)))
          .addMethod(
            getGetGameUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.GameStatusRequest,
                chessGrpc.Chess.GameStatusResponse>(
                  this, METHODID_GET_GAME_UPDATE)))
          .addMethod(
            getVerifyMoveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.VerifyMoveRequest,
                chessGrpc.Chess.VerifyMoveResponse>(
                  this, METHODID_VERIFY_MOVE)))
          .addMethod(
            getGetMoveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.GetMoveRequest,
                chessGrpc.Chess.GetMoveResponse>(
                  this, METHODID_GET_MOVE)))
          .addMethod(
            getEndGameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.EndGameRequest,
                chessGrpc.Chess.EndGameResponse>(
                  this, METHODID_END_GAME)))
          .addMethod(
            getGetAllMovesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                chessGrpc.Chess.GetAllMovesRequest,
                chessGrpc.Chess.GetAllMovesResponse>(
                  this, METHODID_GET_ALL_MOVES)))
          .build();
    }
  }

  /**
   * <pre>
   * All available ChessServices
   * </pre>
   */
  public static final class ChessGameStub extends io.grpc.stub.AbstractStub<ChessGameStub> {
    private ChessGameStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChessGameStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessGameStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChessGameStub(channel, callOptions);
    }

    /**
     * <pre>
     * When a move is made in the game by the client
     * </pre>
     */
    public void makeMove(chessGrpc.Chess.MakeMoveRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.MakeMoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client asks server if it made a move
     * </pre>
     */
    public void getGameUpdate(chessGrpc.Chess.GameStatusRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.GameStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGameUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyMove(chessGrpc.Chess.VerifyMoveRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.VerifyMoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVerifyMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMove(chessGrpc.Chess.GetMoveRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.GetMoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endGame(chessGrpc.Chess.EndGameRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.EndGameResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEndGameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllMoves(chessGrpc.Chess.GetAllMovesRequest request,
        io.grpc.stub.StreamObserver<chessGrpc.Chess.GetAllMovesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllMovesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * All available ChessServices
   * </pre>
   */
  public static final class ChessGameBlockingStub extends io.grpc.stub.AbstractStub<ChessGameBlockingStub> {
    private ChessGameBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChessGameBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessGameBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChessGameBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * When a move is made in the game by the client
     * </pre>
     */
    public chessGrpc.Chess.MakeMoveResponse makeMove(chessGrpc.Chess.MakeMoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeMoveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Client asks server if it made a move
     * </pre>
     */
    public chessGrpc.Chess.GameStatusResponse getGameUpdate(chessGrpc.Chess.GameStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGameUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public chessGrpc.Chess.VerifyMoveResponse verifyMove(chessGrpc.Chess.VerifyMoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getVerifyMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public chessGrpc.Chess.GetMoveResponse getMove(chessGrpc.Chess.GetMoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public chessGrpc.Chess.EndGameResponse endGame(chessGrpc.Chess.EndGameRequest request) {
      return blockingUnaryCall(
          getChannel(), getEndGameMethod(), getCallOptions(), request);
    }

    /**
     */
    public chessGrpc.Chess.GetAllMovesResponse getAllMoves(chessGrpc.Chess.GetAllMovesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllMovesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * All available ChessServices
   * </pre>
   */
  public static final class ChessGameFutureStub extends io.grpc.stub.AbstractStub<ChessGameFutureStub> {
    private ChessGameFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChessGameFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessGameFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChessGameFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * When a move is made in the game by the client
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.MakeMoveResponse> makeMove(
        chessGrpc.Chess.MakeMoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Client asks server if it made a move
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.GameStatusResponse> getGameUpdate(
        chessGrpc.Chess.GameStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGameUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.VerifyMoveResponse> verifyMove(
        chessGrpc.Chess.VerifyMoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVerifyMoveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.GetMoveResponse> getMove(
        chessGrpc.Chess.GetMoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMoveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.EndGameResponse> endGame(
        chessGrpc.Chess.EndGameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEndGameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<chessGrpc.Chess.GetAllMovesResponse> getAllMoves(
        chessGrpc.Chess.GetAllMovesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllMovesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_MOVE = 0;
  private static final int METHODID_GET_GAME_UPDATE = 1;
  private static final int METHODID_VERIFY_MOVE = 2;
  private static final int METHODID_GET_MOVE = 3;
  private static final int METHODID_END_GAME = 4;
  private static final int METHODID_GET_ALL_MOVES = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChessGameImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChessGameImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_MOVE:
          serviceImpl.makeMove((chessGrpc.Chess.MakeMoveRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.MakeMoveResponse>) responseObserver);
          break;
        case METHODID_GET_GAME_UPDATE:
          serviceImpl.getGameUpdate((chessGrpc.Chess.GameStatusRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.GameStatusResponse>) responseObserver);
          break;
        case METHODID_VERIFY_MOVE:
          serviceImpl.verifyMove((chessGrpc.Chess.VerifyMoveRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.VerifyMoveResponse>) responseObserver);
          break;
        case METHODID_GET_MOVE:
          serviceImpl.getMove((chessGrpc.Chess.GetMoveRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.GetMoveResponse>) responseObserver);
          break;
        case METHODID_END_GAME:
          serviceImpl.endGame((chessGrpc.Chess.EndGameRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.EndGameResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_MOVES:
          serviceImpl.getAllMoves((chessGrpc.Chess.GetAllMovesRequest) request,
              (io.grpc.stub.StreamObserver<chessGrpc.Chess.GetAllMovesResponse>) responseObserver);
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

  private static abstract class ChessGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChessGameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chessGrpc.Chess.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChessGame");
    }
  }

  private static final class ChessGameFileDescriptorSupplier
      extends ChessGameBaseDescriptorSupplier {
    ChessGameFileDescriptorSupplier() {}
  }

  private static final class ChessGameMethodDescriptorSupplier
      extends ChessGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChessGameMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChessGameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChessGameFileDescriptorSupplier())
              .addMethod(getMakeMoveMethod())
              .addMethod(getGetGameUpdateMethod())
              .addMethod(getVerifyMoveMethod())
              .addMethod(getGetMoveMethod())
              .addMethod(getEndGameMethod())
              .addMethod(getGetAllMovesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
