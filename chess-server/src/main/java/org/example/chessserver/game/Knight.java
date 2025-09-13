package org.example.chessserver.game;

import org.example.chessserver.game.strategy.KnightMove;

public class Knight extends Piece {
    public Knight(boolean white) {
        super(white, new KnightMove());
    }
}
