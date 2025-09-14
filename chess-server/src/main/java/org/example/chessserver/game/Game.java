package org.example.chessserver.game;

import org.example.chessserver.game.command.MoveCommand;
import org.example.chessserver.game.memento.GameCaretaker;
import org.example.chessserver.game.memento.GameMemento;
import org.example.chessserver.game.observer.GameEventPublisher;
import org.example.chessserver.game.states.WaitingForOpponentState;
import org.example.chessserver.user.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player white;
    private Player black;
    private Board board;
    private GameState state;
    private List<MoveCommand> moveHistory;
    private GameCaretaker caretaker;
    private GameEventPublisher eventPublisher;

    public Game(Player white, Player black) {
        this.white = white;
        this.black = black;
        this.board = new Board();
        this.state = new WaitingForOpponentState(this);
        this.caretaker = new GameCaretaker();
        this.eventPublisher = new GameEventPublisher();
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Board getBoard() {
        return board;
    }

    public void makeMove(MoveCommand command){
        if (state.canMove()){
            command.execute();
            moveHistory.add(command);
            caretaker.addMemento(new GameMemento(this));
            eventPublisher.notifyMove(command);
            state.afterMove();
        }
    }

    public void undo() {
        if (!moveHistory.isEmpty()) {
            MoveCommand last = moveHistory.remove(moveHistory.size() - 1);
            last.undo();
            caretaker.undo();
            eventPublisher.notifyUndo(last);
        }
    }

    public void replay() {
        for (MoveCommand cmd : moveHistory) {
            cmd.execute();
            // có thể delay để FE render
        }
    }

    public List<String> getMoveHistoryAsString() {
        List<String> historyStr = new ArrayList<>();
        for (MoveCommand cmd : moveHistory) {
            historyStr.add(cmd.getFrom().toString() + "-" + cmd.getTo().toString());
        }
        return historyStr;
    }

    public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }
}
