package org.example.chessserver.game.states;

import org.example.chessserver.game.Game;
import org.example.chessserver.game.GameState;

public class WaitingForOpponentState extends GameState {

    public WaitingForOpponentState(Game game) {
        super(game);
    }

    @Override
    public boolean canMove() {
        return false; // chưa có đối thủ
    }

    @Override
    public void afterMove() {
        // không làm gì
    }

    public void opponentJoined() {
        game.setState(new InProgressState(game));
    }
}
