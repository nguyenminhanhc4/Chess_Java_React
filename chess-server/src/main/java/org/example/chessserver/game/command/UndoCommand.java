package org.example.chessserver.game.command;

import org.example.chessserver.game.Game;

public class UndoCommand implements Command {

    private Game game;

    public UndoCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.undo();
    }

    @Override
    public void undo() {
        // không cần implement hoặc có thể redo
        game.replay();
    }
}
