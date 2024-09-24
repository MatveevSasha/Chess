public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color, "R");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {
        if ((line == toline && column != toColumn) || (line != toline && column == toColumn)) {

            if ((column == toColumn) && (line == toline)) {
                for (int i = line - 1; i > toline; i--) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }
            if ((column == toColumn) && (line == toline)) {
                for (int i = line + 1; i < toline; i++){
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }
            if ((line == toline) && (column == toColumn)) {
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }
            if ((line == toline) && (column == toColumn)) {
                for (int i = column - 1; i < toColumn; i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            }
        }else {
            return false;
        }
        return chessBoard.board[toline][toColumn] == null ||
                !chessBoard.board[toline][toColumn].getColor().equals(this.getColor());
    }
}
