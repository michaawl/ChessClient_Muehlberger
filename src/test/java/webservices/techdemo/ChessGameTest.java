package webservices.techdemo;

import Pieces.ChessPiece;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameTest {

    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        chessGame = new ChessGame();
    }

    @Test
    void testPopulateChessPieces() {
        List<ChessPiece> pieces = ChessGame.PopulateChessPieces();
        assertEquals(32, pieces.size());
    }

    @Test
    void testFindPieceAtPosition() {
        List<ChessPiece> pieces = ChessGame.PopulateChessPieces();
        ChessPiece piece = ChessGame.findPieceAtPosition("e1", pieces);
        assertNotNull(piece);
        assertEquals("K", piece.getName());
    }
}
