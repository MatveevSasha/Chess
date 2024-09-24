public class Bishop extends ChessPiece{
    public Bishop(String color) {
        super(color, "B");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {

        if ((line != toline && column != toColumn) &&
                (Math.abs(toline - line) == Math.abs(toColumn - column))) {
            if (line < toline && column > toColumn) {
                int j = column;
                for (int i = line + 1; i < toline; i++) {
                    j--;
                    if (chessBoard.board[i][j] != null) {
                        return false;
                    }
                }
            }
            if (line > toline && column > toColumn) {
                int j = column;
                for (int i = line - 1; i > toline; i--) {
                    j--;
                    if (chessBoard.board[i][j] != null) {
                        return false;
                    }
                }
            }
            if (line < toline && column < toColumn) {
                int j = column;
                for (int i = line + 1; i < toline; i++) {
                    j++;
                    if (chessBoard.board[i][j] != null) {
                        return false;
                    }
                }
            }
            if (line > toline && column < toColumn) {
                int j = column;
                for (int i = line - 1; i > toline; i--) {
                    j++;
                    if (chessBoard.board[i][j] != null) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return chessBoard.board[toline][toColumn] == null ||
                !chessBoard.board[toline][toColumn].getColor().equals(this.getColor());
    }
}
