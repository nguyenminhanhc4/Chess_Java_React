package org.example.chessserver.game;

import org.example.chessserver.game.strategy.BishopMove;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white, new BishopMove());
    }
}
