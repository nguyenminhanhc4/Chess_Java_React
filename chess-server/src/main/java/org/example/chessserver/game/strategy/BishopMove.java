package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.util.MoveUtils;

public class BishopMove implements MoveStrategy {
    @Override
    public boolean isValidMove(Board board, Move move) {
        Piece piece = board.getPiece(move.getFrom());
        if (piece == null) return false;

        if (!MoveUtils.isDiagonal(move)) return false;

        // đường đi phải trống (trừ ô đích)
        if (board.isPathClear(move.getFrom(), move.getTo())) return false;

        // ô đích trống
        if (board.isEmpty(move.getTo())) return true;

        // hoặc có quân đối thủ
        return board.hasOpponentPiece(move.getTo(), piece.isWhite());
    }
}
