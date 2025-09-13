package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.util.MoveUtils;

public class QueenMove implements MoveStrategy {
    @Override
    public boolean isValidMove(Board board, Move move) {
        Piece piece = MoveUtils.getPieceOrNull(board, move);
        if (piece == null) return false;

        // Queen hợp lệ nếu đi chéo hoặc đi thẳng
        if (!(MoveUtils.isDiagonal(move) || MoveUtils.isStraight(move))) return false;

        // Đường đi phải trống
        if (board.isPathClear(move.getFrom(), move.getTo())) return false;

        // Đích trống hoặc có quân đối thủ
        return board.isEmpty(move.getTo()) ||
                board.hasOpponentPiece(move.getTo(), piece.isWhite());
    }
}
