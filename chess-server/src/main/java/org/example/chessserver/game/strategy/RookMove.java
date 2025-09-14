package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.Position;
import org.example.chessserver.game.util.MoveUtils;

import java.util.List;

public class RookMove implements MoveStrategy {
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
        Piece piece = MoveUtils.getPieceOrNull(board, move);
        if (piece == null) return false;

        // Rook chỉ đi thẳng
        if (!MoveUtils.isStraight(move)) return false;

        // Kiểm tra đường đi
        if (board.isPathClear(move.getFrom(), move.getTo())) return false;

        // Đích trống hoặc có quân đối thủ
        return board.isEmpty(move.getTo()) ||
                board.hasOpponentPiece(move.getTo(), piece.isWhite());
    }
}
