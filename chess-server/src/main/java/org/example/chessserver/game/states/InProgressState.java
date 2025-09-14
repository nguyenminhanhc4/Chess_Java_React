package org.example.chessserver.game.states;

import org.example.chessserver.game.Game;
import org.example.chessserver.game.GameState;

public class InProgressState extends GameState {

    public InProgressState(Game game) {
        super(game);
    }

    @Override
    public boolean canMove() {
        return true; // đang chơi
    }

    @Override
    public void afterMove() {
        // kiểm tra thắng/thua/hòa → nếu xong thì chuyển trạng thái
        // game.setState(new FinishedState(game));
    }
}
