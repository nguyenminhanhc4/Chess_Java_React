package org.example.chessserver.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopMoveTest {
    @Test
    void testBishopValidMoveDiagonal() {
        Board board = new Board();
        Bishop bishop = new Bishop(true);
        Position start = new Position(2, 0); // c1
        board.setPiece(start, bishop);

        Move move = new Move(start, new Position(5, 3)); // c1 -> f4
        assertTrue(bishop.canMove(board, move));
    }

    @Test
    void testBishopBlockedByPiece() {
        Board board = new Board();
        Bishop bishop = new Bishop(true);
        Position start = new Position(2, 0);
        board.setPiece(start, bishop);

        // chặn đường đi
        board.setPiece(new Position(3, 1), new Pawn(true));

        Move move = new Move(start, new Position(5, 3));
        assertFalse(bishop.canMove(board, move));
    }

    @Test
    void testBishopCaptureOpponent() {
        Board board = new Board();
        Bishop bishop = new Bishop(true);
        Position start = new Position(2, 0);
        board.setPiece(start, bishop);

        Position target = new Position(5, 3);
        board.setPiece(target, new Pawn(false));

        Move move = new Move(start, target);
        assertTrue(bishop.canMove(board, move));
    }

    @Test
    void testBishopCannotCaptureOwnPiece() {
        Board board = new Board();
        Bishop bishop = new Bishop(true);
        Position start = new Position(2, 0);
        board.setPiece(start, bishop);

        Position target = new Position(5, 3);
        board.setPiece(target, new Pawn(true));

        Move move = new Move(start, target);
        assertFalse(bishop.canMove(board, move));
    }

    @Test
    void testBishopInvalidNonDiagonal() {
        Board board = new Board();
        Bishop bishop = new Bishop(true);
        Position start = new Position(2, 0);
        board.setPiece(start, bishop);

        Move move = new Move(start, new Position(2, 3)); // đi thẳng
        assertFalse(bishop.canMove(board, move));
    }
}
