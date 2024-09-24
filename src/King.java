public class King extends ChessPiece{
    public King(String color) {
        super(color, "K");
    }



    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {
        if (Math.abs(line - toline) > 1 || Math.abs(column - toColumn) > 1) {
            return false;
        }
        if (chessBoard.board[toline][toColumn] != null && chessBoard.board[toline][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        return !isUnderAttack(chessBoard, line, column, toline, toColumn);
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column, int toline, int toColumn) {
        boolean isTrue = false;

        ChessPiece tempChessPiece = chessBoard.board[toline][toColumn];
        chessBoard.board[toline][toColumn] = new King(this.getColor());
        chessBoard.board[line][column] = null;

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (chessBoard.board[i][j].getColor().equals(this.getColor()) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, toline, toColumn)) {
                        isTrue = true;
                    }
                }
            }
        }
        chessBoard.board[toline][toColumn] = tempChessPiece;
        chessBoard.board[line][column] = new King(this.getColor());

        return isTrue;
    }

}
