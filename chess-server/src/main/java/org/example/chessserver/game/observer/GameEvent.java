package org.example.chessserver.game.observer;

import org.example.chessserver.game.command.MoveCommand;

public class GameEvent {

    public enum EventType { MOVE, UNDO, STATE_CHANGE }

    private EventType type;
    private MoveCommand moveCommand;
    private Object state;

    public GameEvent(EventType type) {
        this.type = type;
    }

    public GameEvent(EventType type, MoveCommand moveCommand) {
        this.type = type;
        this.moveCommand = moveCommand;
    }

    public GameEvent(EventType type, Object state) {
        this.type = type;
        this.state = state;
    }

    public EventType getType() { return type; }
    public MoveCommand getMoveCommand() { return moveCommand; }
    public Object getState() { return state; }
}
