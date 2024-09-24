abstract class ChessPiece {
    private final String color;
    private final String symbol;
    boolean check = true;

    public  ChessPiece(String color, String symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn);

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public boolean checPos(int pos) {
        return pos >= 0 && pos <=7;
    }
}