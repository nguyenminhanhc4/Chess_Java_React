package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;

public class BishopMove implements MoveStrategy {
    @Override
    public boolean isValidMove(Board board, Move move) {
        Piece piece = board.getPiece(move.getFrom());
        if (piece == null) return false;

        int dx = Math.abs(move.getTo().getX() - move.getFrom().getX());
        int dy = Math.abs(move.getTo().getY() - move.getFrom().getY());

        // phải đi chéo: |dx| == |dy|
        if (dx != dy) return false;

        // đường đi phải trống (trừ ô đích)
        if (!board.isPathClear(move.getFrom(), move.getTo())) return false;

        // ô đích trống
        if (board.isEmpty(move.getTo())) return true;

        // hoặc có quân đối thủ
        return board.hasOpponentPiece(move.getTo(), piece.isWhite());
    }
}
