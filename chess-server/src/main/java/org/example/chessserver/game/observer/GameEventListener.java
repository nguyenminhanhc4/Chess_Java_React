package org.example.chessserver.game.observer;

public class GameEventListener implements GameObserver {

    @Override
    public void onGameEvent(GameEvent event) {
        switch (event.getType()) {
            case MOVE -> System.out.println("Move made: " + event.getMoveCommand());
            case UNDO -> System.out.println("Undo move: " + event.getMoveCommand());
            case STATE_CHANGE -> System.out.println("State changed: " + event.getState());
        }
        // ở FE có thể push lên websocket
    }
}
