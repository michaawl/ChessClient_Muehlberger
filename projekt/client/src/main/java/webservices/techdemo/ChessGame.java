package webservices.techdemo;

import Pieces.*;
import chessGrpc.Chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ChessGame {

    private ChessService chessService;

    public ChessGame() {
        this.chessService = new ChessService();
    }

    static String playerName = "";

    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        playerName = scanner.nextLine();

        //registering game
        Chess.StartGameResponse startGameResponse = null;
        while (true) {
            try {
                startGameResponse = chessService.StartMatchmaking(scanner, playerName);
                break;
            } catch (Exception e) {
                System.out.println("Connecting to server...");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted");
                return;
            }
        }

        Chess.GameStatusResponse gameStatusResponse;
        String gameId = startGameResponse.getGameId();
        String playerColor = startGameResponse.getPlayerColor();

        List<ChessPiece> pieces = PopulateChessPieces();

        //matchmaking - looking for opponent
        while (true) {
            gameStatusResponse = chessService.checkGameStatus(gameId);

            if ("ongoing".equalsIgnoreCase(gameStatusResponse.getStatus())) {
                System.out.println("Player found! Starting game...\n\n");
                break;
            } else {
                System.out.println("Waiting for game to start...");
            }


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted");
                break;
            }
        }

        boolean movedPiecesAfterVerify = true;
        drawChessBoard(pieces);
        String winner = "";

        // actual chess game
        while ( true ) {

            gameStatusResponse = chessService.checkGameStatus(gameId);
            String currentTurn = gameStatusResponse.getCurrentTurn();
            boolean isValidated = gameStatusResponse.getIsVerified();
            String lastPlayedOriginMove = gameStatusResponse.getLastMoveOrigin();
            String lastPlayedDesinationMove = gameStatusResponse.getLastMoveDesination();
            String gameStatus = gameStatusResponse.getStatus();

            //Check if game ended
            winner = capturedKing( pieces );
            if ( !winner.isEmpty() ) {

                if( winner.equals("k")){
                    winner = "white";
                } else {
                    winner = "black";
                }

                chessService.hasGameEnded(gameId, winner);

                break;
            }

            //Make Move
            if( currentTurn.equals(playerColor) && isValidated && gameStatus.equals("ongoing")){
                MakeMove( scanner, pieces, gameId);
            }

            //Wait Verify
            if( currentTurn.equals(playerColor) && !isValidated ){
                System.out.println("Waiting for other player validate move ...");
                movedPiecesAfterVerify = false;
            }

            //Wait for Player
            if( !currentTurn.equals(playerColor) && isValidated && gameStatus.equals("ongoing")){

                if( movedPiecesAfterVerify == false ){

                    System.out.println("Move validated!");
                    System.out.println();

                    ChessPiece pieceToMove = findPieceAtPosition(lastPlayedOriginMove, pieces);
                    pieces.removeIf(p -> p.getPosition().equals(lastPlayedDesinationMove));
                    pieceToMove.setPosition(lastPlayedDesinationMove);

                    movedPiecesAfterVerify = true;
                    drawChessBoard(pieces);
                }

                System.out.println("Waiting for other player to make move ...");
            }

            //Verify
            if( !currentTurn.equals(playerColor) && !isValidated && !lastPlayedOriginMove.isEmpty()){

                boolean isMoveVerified = VerifyMove( scanner, gameId, lastPlayedOriginMove, lastPlayedDesinationMove );

                if(  isMoveVerified ) {
                    ChessPiece pieceToMove = findPieceAtPosition(lastPlayedOriginMove, pieces);
                    pieces.removeIf(p -> p.getPosition().equals(lastPlayedDesinationMove));
                    pieceToMove.setPosition(lastPlayedDesinationMove);
                    drawChessBoard(pieces);
                }
            }

            try {
                Thread.sleep(2000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted");
                break;
            }
        }


        //Ask if players wants to see the moves
        System.out.println("Do you want to see all the moves made in the game? (yes/no): ");
        String showMoves = scanner.nextLine();
        if (showMoves.equalsIgnoreCase("yes")) {
            List<Chess.SingleMove> moves = chessService.getAllMoves(gameId);
            printAllMoves(moves);
        }
    }

    private static String capturedKing(List<ChessPiece> pieces) {
        boolean whiteKingPresent = false;
        boolean blackKingPresent = false;

        for (ChessPiece piece : pieces) {
            if (piece instanceof King) {
                if (piece.getColor() == Color.WHITE) {
                    whiteKingPresent = true;
                } else if (piece.getColor() == Color.BLACK) {
                    blackKingPresent = true;
                }
            }
        }

        if (!whiteKingPresent) {
            return "K";
        } else if (!blackKingPresent) {
            return "k";
        }

        return "";
    }


    public boolean VerifyMove(Scanner scanner, String gameId, String originMove, String destinationMove) {
        System.out.println("Verify the move: " + originMove + " to " + destinationMove + " (yes/no): ");
        String verification = scanner.nextLine();

        boolean isVerified = verification.equalsIgnoreCase("yes");

        Chess.VerifyMoveResponse verifyMoveResponse = chessService.verifyMoveRequest(gameId, isVerified);

        if (isVerified) {
            return true;
        } else {
            return false;
        }
    }



    public void MakeMove(Scanner scanner, List<ChessPiece> pieces, String gameId) {
        while (true) {
            System.out.print("Enter origin (e.g. e2): ");
            String origin = scanner.nextLine();
            System.out.print("Enter destination (e.g. e4): ");
            String destination = scanner.nextLine();

            ChessPiece pieceToMove = findPieceAtPosition(origin, pieces);
            if (pieceToMove == null) {
                System.out.println("No piece at the origin position.");
                continue;
            }

            Chess.MakeMoveResponse makeMoveResponse = chessService.makeMoveRequest(gameId, playerName, pieceToMove.getName(), origin, destination);
            if (makeMoveResponse.getSuccess()) {
                System.out.println("Move made.");
                break;
            } else {
                System.out.println("Move failed: " + makeMoveResponse.getMessage());
            }
        }
    }

    public static ChessPiece findPieceAtPosition(String position, List<ChessPiece> pieces) {
        for (ChessPiece piece : pieces) {
            if (piece.getPosition().equals(position)) {
                return piece;
            }
        }
        return null;
    }

    public static void drawChessBoard(List<ChessPiece> pieces) {
        HashMap<String, ChessPiece> piecesMap = new HashMap<>();

        // Adding pieces from  list to the HashMap
        for (ChessPiece piece : pieces) {
            piecesMap.put(piece.getPosition(), piece);
        }

        // Initialize chessboard with empty fields
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ".";
            }
        }

        // Place pieces on board
        for (ChessPiece piece : piecesMap.values()) {
            String position = piece.getPosition();
            int row = 8 - Character.getNumericValue(position.charAt(1)); // Convert '2' to 6 (row index)
            int col = position.charAt(0) - 'a'; // Convert 'a' to 0 (column index)
            board[row][col] = piece.getName();
        }

        // Print chessboard
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(String.format("%2s ", board[i][j]));
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    public static List<ChessPiece> PopulateChessPieces(){
        List<ChessPiece> initialList = new ArrayList<ChessPiece>();

        for (char c = 'a'; c <= 'h'; c++) {
            initialList.add(new Pawn(c + "2", Color.WHITE));
            initialList.add(new Pawn(c + "7", Color.BLACK));
        }

        // Rooks
        initialList.add(new Rook("a1", Color.WHITE));
        initialList.add(new Rook("h1", Color.WHITE));
        initialList.add(new Rook("a8", Color.BLACK));
        initialList.add(new Rook("h8", Color.BLACK));

        // Knights
        initialList.add(new Knight("b1", Color.WHITE));
        initialList.add(new Knight("g1", Color.WHITE));
        initialList.add(new Knight("b8", Color.BLACK));
        initialList.add(new Knight("g8", Color.BLACK));

        // Bishops
        initialList.add(new Bishop("c1", Color.WHITE));
        initialList.add(new Bishop("f1", Color.WHITE));
        initialList.add(new Bishop("c8", Color.BLACK));
        initialList.add(new Bishop("f8", Color.BLACK));

        // Queens
        initialList.add(new Queen("d1", Color.WHITE));
        initialList.add(new Queen("d8", Color.BLACK));

        // Kings
        initialList.add(new King("e1", Color.WHITE));
        initialList.add(new King("e8", Color.BLACK));

        return initialList;
    }

    public static void printAllMoves(List<Chess.SingleMove> moves) {
        System.out.println("All moves made in the game:");
        for (Chess.SingleMove move : moves) {
            System.out.printf("%s from %s to %s%n", move.getPiece(), move.getMoveOrigin(), move.getMoveDestination());
        }
    }

    public static ChessPiece createPiece(String pieceType, String position) {
        Color color = Character.isUpperCase(pieceType.charAt(0)) ? Color.WHITE : Color.BLACK;
        pieceType = pieceType.toUpperCase();

        if( !(position.length() == 2 &&
                position.charAt(0) >= 'a' && position.charAt(0) <= 'h' &&
                position.charAt(1) >= '1' && position.charAt(1) <= '8' ))
        {
            return null;
        }

        switch (pieceType) {
            case "P":
                return new Pawn(position, color);
            case "R":
                return new Rook(position, color);
            case "N":
                return new Knight(position, color);
            case "B":
                return new Bishop(position, color);
            case "Q":
                return new Queen(position, color);
            case "K":
                return new King(position, color);
            default:
                return null;
        }
    }

}
