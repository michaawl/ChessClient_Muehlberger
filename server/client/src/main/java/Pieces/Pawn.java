package Pieces;

public class Pawn implements ChessPiece{
    private String name;
    private Color color;
    private String position;

    public Pawn(String position, Color color){
        this.name = color == Color.WHITE ? "P" : "p";
        this.color = color;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }
}
