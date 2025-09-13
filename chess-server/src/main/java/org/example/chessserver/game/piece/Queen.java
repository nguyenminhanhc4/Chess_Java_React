package org.example.chessserver.game.piece;

import org.example.chessserver.game.Piece;
import org.example.chessserver.game.strategy.QueenMove;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white, new QueenMove());
    }
}
