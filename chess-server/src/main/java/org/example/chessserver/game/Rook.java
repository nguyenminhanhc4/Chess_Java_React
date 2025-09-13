package org.example.chessserver.game;

import org.example.chessserver.game.strategy.RookMove;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white, new RookMove());
    }
}
