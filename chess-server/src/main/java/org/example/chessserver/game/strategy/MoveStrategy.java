package org.example.chessserver.game.strategy;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Move;

public interface MoveStrategy {
    boolean isValidMove(Board board, Move move);
}
