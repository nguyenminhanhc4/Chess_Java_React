package org.example.chessserver.game;

import org.example.chessserver.game.strategy.QueenMove;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white, new QueenMove());
    }
}
