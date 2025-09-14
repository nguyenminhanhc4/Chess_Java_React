package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.Position;
import org.example.chessserver.game.util.MoveUtils;

import java.util.List;

public class KnightMove implements MoveStrategy {
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
        Piece piece = board.getPiece(move.getFrom());
        if (piece == null) return false;

        int dx = MoveUtils.dx(move);
        int dy = MoveUtils.dy(move);

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
