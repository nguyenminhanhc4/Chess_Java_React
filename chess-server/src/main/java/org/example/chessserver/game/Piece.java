package org.example.chessserver.game;

import lombok.Getter;
import org.example.chessserver.game.strategy.MoveStrategy;

public abstract class Piece {
    @Getter
    private final boolean white;
    protected boolean hasMoved = false;
    protected MoveStrategy moveStrategy;

    public Piece(boolean white, MoveStrategy strategy) {
        this.white = white;
        this.moveStrategy = strategy;
    }

    public boolean hasMoved() { return hasMoved; }
    public boolean isFirstMove() { return !hasMoved; }

    public boolean canMove(Board board, Move move) {
        return moveStrategy.isValidMove(board, move);
    }
}

