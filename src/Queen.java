public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color, "Q");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {
        if ((line != toline && column != toColumn) &&
                (Math.abs(toline - line) == Math.abs(toColumn - column)) ||
                ((line == toline && column != toColumn) || (line != toline && column == toColumn))) {
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
                for (int i = line + 1; i > toline; i++) {
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
            if ((column == toColumn) && (line == toline)) {
                for (int i = line - 1; i > toline; i--) {
                    if (chessBoard.board[i][column] != null) {
                        return  false;
                    }
                }
            }
            if ((column == toColumn) && (line == toline)) {
                for (int i = line + 1; i < toline; i++) {
                    if (chessBoard.board[i][column] != null) {
                        return  false;
                    }
                }
            }
            if ((line == toline) && (column > toColumn)) {
                for (int i = column - 1; i < toColumn; i--) {
                    if (chessBoard.board[line][i] != null) {
                        return  false;
                    }
                }
            }
            if ((line == toline) && (column < toColumn)) {
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.board[line][i] != null) {
                        return  false;
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
