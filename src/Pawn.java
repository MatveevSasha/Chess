public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color, "P");
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {
        if (chessBoard.board[toline][toColumn] == null && column == toColumn) {
            if (check) {
                if (this.getColor().equals("White")) {
                    if (chessBoard.board[line + 1][column] != null) {
                        return false;
                    }
                    return line - toline == -1 || line - toline == -2;
                } else {
                    if (chessBoard.board[line - 1][column] != null) {
                        return false;
                    }
                    return line - toline == 1 || line - toline == 2;
                }
            } else {
                if (this.getColor().equals("White")) {
                    return line - toline == -1;
                } else {
                    return line - toline == 1;
                }
            }
        }
        if (chessBoard.board[toline][toColumn] != null && !chessBoard.board[toline][toColumn].getColor().equals(this.getColor())) {
            if (this.getColor().equals("White")) {
                return line - toline == -1 && Math.abs(column - toColumn) == 1;
            } else {
                return line - toline == 1 && Math.abs(column - toColumn) == 1;
            }
        }
        return false;
    }
}
