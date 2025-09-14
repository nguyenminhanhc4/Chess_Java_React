package org.example.chessserver.game;

public abstract class GameState {
    protected Game game;

    public GameState(Game game) {
        this.game = game;
    }

    // Kiểm tra có thể đi nước tiếp theo không
    public abstract boolean canMove();

    // Hành động sau mỗi nước đi
    public abstract void afterMove();

    // Có thể override thêm: joinGame(), finishGame(), etc.
}
