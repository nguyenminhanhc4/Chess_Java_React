package org.example.chessserver.game;

import org.example.chessserver.game.piece.Pawn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnMoveTest {

    @Test
    void testPawnSingleStep() {
        Board board = new Board();
        Position start = new Position(4, 1); // white pawn tại e2
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        Move move = new Move(start, new Position(4, 2)); // e2 -> e3
        assertTrue(pawn.canMove(board, move));
    }

    @Test
    void testPawnBlocked() {
        Board board = new Board();
        Position start = new Position(4, 1);
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        // chặn trước mặt
        board.setPiece(new Position(4, 2), new Pawn(false));

        Move move = new Move(start, new Position(4, 2));
        assertFalse(pawn.canMove(board, move));
    }

    @Test
    void testPawnDoubleStepFirstMove() {
        Board board = new Board();
        Position start = new Position(4, 1); // e2
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        Move move = new Move(start, new Position(4, 3)); // e2 -> e4
        assertTrue(pawn.canMove(board, move));
    }

    @Test
    void testPawnCannotDoubleStepAfterMoved() {
        Board board = new Board();
        Position start = new Position(4, 1);
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        // giả lập đã đi 1 lần
        pawn.setHasMoved(true);

        Move move = new Move(start, new Position(4, 3)); // e2 -> e4
        assertFalse(pawn.canMove(board, move));
    }

    @Test
    void testPawnCaptureDiagonal() {
        Board board = new Board();
        Position start = new Position(4, 1);
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        // có quân đen ở chéo
        board.setPiece(new Position(5, 2), new Pawn(false));

        Move move = new Move(start, new Position(5, 2));
        assertTrue(pawn.canMove(board, move));
    }

    @Test
    void testPawnCannotMoveDiagonalIfEmpty() {
        Board board = new Board();
        Position start = new Position(4, 1);
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        Move move = new Move(start, new Position(5, 2)); // chéo nhưng trống
        assertFalse(pawn.canMove(board, move));
    }

    @Test
    void testPawnCannotMoveBackwards() {
        Board board = new Board();
        Position start = new Position(4, 6); // pawn trắng giả định ở hàng 7
        Pawn pawn = new Pawn(true);
        board.setPiece(start, pawn);

        Move move = new Move(start, new Position(4, 5)); // đi lùi xuống
        assertFalse(pawn.canMove(board, move));
    }

}
