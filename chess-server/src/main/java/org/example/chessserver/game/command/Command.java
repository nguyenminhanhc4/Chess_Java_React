package org.example.chessserver.game.command;

public interface Command {
    void execute();
    void undo();
}
