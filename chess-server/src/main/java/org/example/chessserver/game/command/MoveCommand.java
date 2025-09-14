package org.example.chessserver.game.command;
import org.example.chessserver.game.Board;
import org.example.chessserver.game.Game;
import org.example.chessserver.game.Piece;
import org.example.chessserver.game.Position;
import org.example.chessserver.game.strategy.MoveStrategy;

public class MoveCommand implements Command {

    private final Game game;
    private final MoveStrategy pieceStrategy;
    private final Position from;
    private final Position to;
    private Object  capturedPiece; // nếu có ăn quân
    private Piece movingPiece;

    public MoveCommand(Game game, MoveStrategy pieceStrategy, Position from, Position to) {
        this.game = game;
        this.pieceStrategy = pieceStrategy;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        Board board = game.getBoard();
        capturedPiece = board.getPiece(to); // vẫn dùng board
        Piece movingPiece = board.getPiece(from);
        pieceStrategy.move(board, from, to); // dùng strategy di chuyển
        this.movingPiece = movingPiece;
    }

    @Override
    public void undo() {
        Board board = game.getBoard();
        board.setPiece(from, movingPiece);
        board.setPiece(to, capturedPiece != null ? (Piece) capturedPiece : null);
    }

    public Position getFrom() { return from; }
    public Position getTo() { return to; }
}
