package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;

public class KnightMove implements MoveStrategy {
    @Override
    public boolean isValidMove(Board board, Move move) {
        Piece piece = board.getPiece(move.getFrom());
        if (piece == null) return false;

        int dx = Math.abs(move.getTo().getX() - move.getFrom().getX());
        int dy = Math.abs(move.getTo().getY() - move.getFrom().getY());

        // chỉ hợp lệ khi (2,1) hoặc (1,2)
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
            return false;
        }

        // ô đích trống → OK
        if (board.isEmpty(move.getTo())) return true;

        // ô đích có quân đối thủ → OK
        return board.hasOpponentPiece(move.getTo(), piece.isWhite());
    }
}
