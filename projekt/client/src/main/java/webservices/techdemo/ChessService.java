package webservices.techdemo;

import chessGrpc.Chess;
import chessGrpc.ChessGameGrpc;
import chessGrpc.ChessMatchmakingGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;
import java.util.Scanner;

public class ChessService {

    public static Chess.StartGameResponse StartMatchmaking(Scanner scanner, String playerName) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5143).usePlaintext().build();

        ChessMatchmakingGrpc.ChessMatchmakingBlockingStub matchmakingStub = ChessMatchmakingGrpc.newBlockingStub(channel);

        Chess.StartGameRequest startGameRequest = Chess.StartGameRequest.newBuilder().setPlayerName(playerName).build();

        Chess.StartGameResponse startGameResponse = matchmakingStub.startGame(startGameRequest);

        System.out.println("Game started with ID: " + startGameResponse.getGameId());
        System.out.println("You play: " + startGameResponse.getPlayerColor());
        System.out.println();

        return startGameResponse;
    }

    public static Chess.GameStatusResponse checkGameStatus(String gameId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5143).usePlaintext().build();

        ChessGameGrpc.ChessGameBlockingStub gameStub = ChessGameGrpc.newBlockingStub(channel);

        Chess.GameStatusRequest gameStatusRequest = Chess.GameStatusRequest.newBuilder().setGameId(gameId).build();

        Chess.GameStatusResponse gameStatusResponse = gameStub.getGameUpdate(gameStatusRequest);

        channel.shutdown();

        return gameStatusResponse;
    }

    public static Chess.MakeMoveResponse makeMoveRequest(String gameId, String playerName, String piece, String moveOrigin, String moveDestination) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5143).usePlaintext().build();
        ChessGameGrpc.ChessGameBlockingStub gameStub = ChessGameGrpc.newBlockingStub(channel);

        Chess.MakeMoveRequest makeMoveRequest = Chess.MakeMoveRequest.newBuilder()
                .setGameId(gameId)
                .setPlayerName(playerName)
                .setPiece(piece)
                .setMoveOrigin(moveOrigin)
                .setMoveDestination(moveDestination)
                .build();

        Chess.MakeMoveResponse makeMoveResponse = gameStub.makeMove(makeMoveRequest);
        channel.shutdown();

        return makeMoveResponse;
    }

    public static Chess.VerifyMoveResponse verifyMoveRequest(String gameId, boolean isVerified) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5143).usePlaintext().build();
        ChessGameGrpc.ChessGameBlockingStub gameStub = ChessGameGrpc.newBlockingStub(channel);

        Chess.VerifyMoveRequest verifyMoveRequest = Chess.VerifyMoveRequest.newBuilder()
                .setGameId(gameId)
                .setOpponentAnswer(isVerified)
                .build();

        Chess.VerifyMoveResponse verifyMoveResponse = gameStub.verifyMove(verifyMoveRequest);
        channel.shutdown();

        return verifyMoveResponse;
    }

    public static List<Chess.SingleMove> getAllMoves(String gameId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5143).usePlaintext().build();
        ChessGameGrpc.ChessGameBlockingStub gameStub = ChessGameGrpc.newBlockingStub(channel);

        Chess.GetAllMovesRequest getAllMovesRequest = Chess.GetAllMovesRequest.newBuilder()
                .setGameId(gameId)
                .build();

        Chess.GetAllMovesResponse getAllMovesResponse = gameStub.getAllMoves(getAllMovesRequest);
        channel.shutdown();

        return getAllMovesResponse.getMovesList();
    }

    public static boolean hasGameEnded(String gameId, String winner) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5143).usePlaintext().build();
        ChessGameGrpc.ChessGameBlockingStub gameStub = ChessGameGrpc.newBlockingStub(channel);

        Chess.EndGameRequest endGameRequest = Chess.EndGameRequest.newBuilder()
                .setGameId(gameId)
                .build();

        Chess.EndGameResponse endGameResponse = gameStub.endGame(endGameRequest);
        channel.shutdown();

        if (endGameResponse.getSuccess()) {
            System.out.printf("Winner: %s%n", winner);
            return true;
        } else {
            System.out.println("Unknown error. Server couldn't end game.");
            return false;
        }
    }


}
