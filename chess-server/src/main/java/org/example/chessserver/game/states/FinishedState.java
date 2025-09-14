package org.example.chessserver.game.states;

import org.example.chessserver.game.Game;
import org.example.chessserver.game.GameState;

public class FinishedState extends GameState {

    public FinishedState(Game game) {
        super(game);
    }

    @Override
    public boolean canMove() {
        return false; // ván kết thúc
    }

    @Override
    public void afterMove() {
        // không làm gì
    }
}
