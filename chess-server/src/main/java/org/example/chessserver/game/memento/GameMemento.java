package org.example.chessserver.game.memento;

import org.example.chessserver.game.Board;
import org.example.chessserver.game.Game;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {

    private Board boardSnapshot;
    private List<String> movesSnapshot;

    public GameMemento(Game game) {
        this.boardSnapshot = new Board(game.getBoard()); // copy constructor
        this.movesSnapshot = new ArrayList<>(game.getMoveHistoryAsString());
    }

    public Board getBoardSnapshot() {
        return boardSnapshot;
    }

    public List<String> getMovesSnapshot() {
        return movesSnapshot;
    }
}
