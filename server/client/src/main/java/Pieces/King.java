package Pieces;

public class King implements ChessPiece{
    private String name;
    private Color color;
    private String position;

    public King(String position, Color color){
        this.name = color == Color.WHITE ? "K" : "k";
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
