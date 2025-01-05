package Pieces;

public interface ChessPiece {

    // Name like the Chess Notation
    public String getName();

    // Color can either be b and w
    public Color getColor();

    // position on the chessboard with lower case letters
    String getPosition();
    void setPosition(String position);
}
