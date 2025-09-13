package org.example.chessserver.game;

import org.example.chessserver.game.strategy.KingMove;

public class King extends Piece {
    public King(boolean white) {
        super(white, new KingMove());
    }
}
