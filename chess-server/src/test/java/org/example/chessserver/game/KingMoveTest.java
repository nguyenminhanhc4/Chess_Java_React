package org.example.chessserver.game;

import org.example.chessserver.game.piece.King;
import org.example.chessserver.game.piece.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingMoveTest {
    @Test
    void testKingMoveOneStep() {
        Board board = new Board();
        King king = new King(true);
        Position start = new Position(4, 0); // e1
        board.setPiece(start, king);

        Move move = new Move(start, new Position(4, 1)); // e1 -> e2
        assertTrue(king.canMove(board, move));
    }

    @Test
    void testKingDiagonalMove() {
        Board board = new Board();
        King king = new King(true);
        Position start = new Position(4, 0);
        board.setPiece(start, king);

        Move move = new Move(start, new Position(5, 1)); // e1 -> f2
        assertTrue(king.canMove(board, move));
    }

    @Test
    void testKingInvalidMoveTwoSteps() {
        Board board = new Board();
        King king = new King(true);
        Position start = new Position(4, 0);
        board.setPiece(start, king);

        Move move = new Move(start, new Position(4, 2)); // e1 -> e3
        assertFalse(king.canMove(board, move));
    }

    @Test
    void testKingCannotCaptureOwnPiece() {
        Board board = new Board();
        King king = new King(true);
        Position start = new Position(4, 0);
        board.setPiece(start, king);

        Position target = new Position(5, 1);
        board.setPiece(target, new Pawn(true)); // đồng minh

        Move move = new Move(start, target);
        assertFalse(king.canMove(board, move));
    }

    @Test
    void testKingCanCaptureOpponent() {
        Board board = new Board();
        King king = new King(true);
        Position start = new Position(4, 0);
        board.setPiece(start, king);

        Position target = new Position(5, 1);
        board.setPiece(target, new Pawn(false)); // đối thủ

        Move move = new Move(start, target);
        assertTrue(king.canMove(board, move));
    }
}
