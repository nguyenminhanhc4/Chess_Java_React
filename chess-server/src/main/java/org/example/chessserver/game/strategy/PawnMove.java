package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.Position;

import java.util.List;

public class PawnMove implements MoveStrategy{
    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public List<Position> getValidMoves(Board board, Position current) {
        return null;
    }

    @Override
    public void move(Board board, Position from, Position to) {

    }

    @Override
    public void undoMove(Board board, Position from, Position to, Object captured) {

    }

    @Override
    public boolean isValidMove(Board board, Move move) {
        // Lấy quân cờ
        Piece piece = board.getPiece(move.getFrom());

        int direction = piece.isWhite() ? 1 : -1;
        int dx = move.getTo().getX() - move.getFrom().getX();
        int dy = move.getTo().getY() - move.getFrom().getY();

        // Đi 1 bước thẳng
        if (dx == 0 && dy == direction && board.isEmpty(move.getTo())) return true;

        // Đi 2 bước thẳng (nếu đang ở hàng xuất phát)
        if (dx == 0 && dy == 2 * direction && piece.isFirstMove()
                && board.isEmpty(move.getTo())
                && board.isEmpty(new Position(move.getFrom().getX(), move.getFrom().getY() + direction))) {
            return true;
        }

        // Ăn chéo
        if (Math.abs(dx) == 1 && dy == direction && board.hasOpponentPiece(move.getTo(), piece.isWhite())) {
            return true;
        }
        return false;
    }
}
