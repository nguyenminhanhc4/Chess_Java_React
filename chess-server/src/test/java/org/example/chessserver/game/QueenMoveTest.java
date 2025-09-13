package org.example.chessserver.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenMoveTest {
    @Test
    void testQueenValidDiagonal() {
        Board board = new Board();
        Queen queen = new Queen(true);
        Position start = new Position(3, 0); // d1
        board.setPiece(start, queen);

        Move move = new Move(start, new Position(6, 3)); // d1 -> g4
        assertTrue(queen.canMove(board, move));
    }

    @Test
    void testQueenValidStraight() {
        Board board = new Board();
        Queen queen = new Queen(true);
        Position start = new Position(3, 0);
        board.setPiece(start, queen);

        Move move = new Move(start, new Position(3, 5)); // d1 -> d6
        assertTrue(queen.canMove(board, move));
    }

    @Test
    void testQueenInvalidKnightMove() {
        Board board = new Board();
        Queen queen = new Queen(true);
        Position start = new Position(3, 0);
        board.setPiece(start, queen);

        Move move = new Move(start, new Position(4, 2)); // d1 -> e3 (chữ L)
        assertFalse(queen.canMove(board, move));
    }

    @Test
    void testQueenBlocked() {
        Board board = new Board();
        Queen queen = new Queen(true);
        Position start = new Position(3, 0);
        board.setPiece(start, queen);

        board.setPiece(new Position(3, 2), new Pawn(true)); // chặn dọc

        Move move = new Move(start, new Position(3, 5));
        assertFalse(queen.canMove(board, move));
    }

    @Test
    void testQueenCaptureOpponent() {
        Board board = new Board();
        Queen queen = new Queen(true);
        Position start = new Position(3, 0);
        board.setPiece(start, queen);

        Position target = new Position(3, 5);
        board.setPiece(target, new Pawn(false));

        Move move = new Move(start, target);
        assertTrue(queen.canMove(board, move));
    }

    @Test
    void testQueenCannotCaptureOwnPiece() {
        Board board = new Board();
        Queen queen = new Queen(true);
        Position start = new Position(3, 0);
        board.setPiece(start, queen);

        Position target = new Position(3, 5);
        board.setPiece(target, new Pawn(true));

        Move move = new Move(start, target);
        assertFalse(queen.canMove(board, move));
    }
}
