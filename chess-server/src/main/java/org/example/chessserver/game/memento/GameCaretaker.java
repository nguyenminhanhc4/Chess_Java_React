package org.example.chessserver.game.memento;

import java.util.Stack;

public class GameCaretaker {

    private Stack<GameMemento> history = new Stack<>();

    public void addMemento(GameMemento memento) {
        history.push(memento);
    }

    public GameMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}
