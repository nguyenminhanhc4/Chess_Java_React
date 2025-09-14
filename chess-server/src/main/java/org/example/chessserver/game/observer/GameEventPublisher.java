package org.example.chessserver.game.observer;

import java.util.ArrayList;
import java.util.List;

public class GameEventPublisher {

    private final List<GameObserver> observers = new ArrayList<>();

    public void registerObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyMove(Object command) {
        GameEvent event = new GameEvent(GameEvent.EventType.MOVE, (org.example.chessserver.game.command.MoveCommand) command);
        notifyObservers(event);
    }

    public void notifyUndo(Object command) {
        GameEvent event = new GameEvent(GameEvent.EventType.UNDO, (org.example.chessserver.game.command.MoveCommand) command);
        notifyObservers(event);
    }

    public void notifyStateChange(Object state) {
        GameEvent event = new GameEvent(GameEvent.EventType.STATE_CHANGE, state);
        notifyObservers(event);
    }

    private void notifyObservers(GameEvent event) {
        for (GameObserver observer : observers) {
            observer.onGameEvent(event);
        }
    }
}
