package org.example.chessserver.game.util;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;

public class MoveUtils {
    public static Piece getPieceOrNull(Board board, Move move) {
        if (board == null || move == null || move.getFrom() == null) return null;
        return board.getPiece(move.getFrom());
    }

    public static int dx(Move move) {
        return Math.abs(move.getTo().getX() - move.getFrom().getX());
    }

    public static int dy(Move move) {
        return Math.abs(move.getTo().getY() - move.getFrom().getY());
    }

    public static boolean isDiagonal(Move move) {
        return dx(move) == dy(move);
    }

    public static boolean isStraight(Move move) {
        return dx(move) == 0 || dy(move) == 0;
    }
}
