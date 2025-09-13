package org.example.chessserver.game;

import lombok.Getter;
import org.example.chessserver.game.strategy.MoveStrategy;
public abstract class Piece {

    private final boolean white;
    protected boolean hasMoved = false;
    protected MoveStrategy moveStrategy;

    public Piece(boolean white, MoveStrategy strategy) {
        this.white = white;
        this.moveStrategy = strategy;
    }
    public boolean isWhite() { return white; }
    public boolean hasMoved() { return hasMoved; }
    public boolean isFirstMove() { return !hasMoved; }

    public void setHasMoved(boolean hasMoved) { this.hasMoved = hasMoved; }

    public boolean canMove(Board board, Move move) {
        return moveStrategy.isValidMove(board, move);
    }
}

