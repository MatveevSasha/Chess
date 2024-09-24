public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color, "H");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {
        if (!(chessBoard.board[ toline][toColumn] == null) && chessBoard.board[toline][toColumn].getColor().equals(this.getColor())){
            return false;
        }
        int deltaX = Math.abs(toline - line);
        int deltaY = Math.abs(toColumn - column);
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }
}