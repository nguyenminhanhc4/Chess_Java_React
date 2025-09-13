package org.example.chessserver.game.piece;

import org.example.chessserver.game.Piece;
import org.example.chessserver.game.strategy.PawnMove;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white, new PawnMove()); // gắn strategy riêng cho Tốt
    }
}