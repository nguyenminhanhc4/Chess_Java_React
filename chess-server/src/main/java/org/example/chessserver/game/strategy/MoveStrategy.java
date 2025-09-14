package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.Position;

import java.util.List;

public interface MoveStrategy {
    Piece getPiece();
    List<Position> getValidMoves(Board board, Position current);
    void move(Board board, Position from, Position to);
    void undoMove(Board board, Position from, Position to, Object captured);
    boolean isValidMove(Board board, Move move);
}
