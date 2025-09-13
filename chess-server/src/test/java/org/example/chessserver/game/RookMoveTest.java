package org.example.chessserver.game;

import org.example.chessserver.game.piece.Pawn;
import org.example.chessserver.game.piece.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookMoveTest {
    @Test
    void testRookValidMoveHorizontal() {
        Board board = new Board();
        Rook rook = new Rook(true);
        Position start = new Position(0, 0); // a1
        board.setPiece(start, rook);

        Move move = new Move(start, new Position(5, 0)); // a1 -> f1
        assertTrue(rook.canMove(board, move));
    }

    @Test
    void testRookValidMoveVertical() {
        Board board = new Board();
        Rook rook = new Rook(true);
        Position start = new Position(0, 0);
        board.setPiece(start, rook);

        Move move = new Move(start, new Position(0, 5)); // a1 -> a6
        assertTrue(rook.canMove(board, move));
    }

    @Test
    void testRookInvalidDiagonal() {
        Board board = new Board();
        Rook rook = new Rook(true);
        Position start = new Position(0, 0);
        board.setPiece(start, rook);

        Move move = new Move(start, new Position(3, 3)); // a1 -> d4 (chéo)
        assertFalse(rook.canMove(board, move));
    }

    @Test
    void testRookBlockedByPiece() {
        Board board = new Board();
        Rook rook = new Rook(true);
        Position start = new Position(0, 0);
        board.setPiece(start, rook);

        board.setPiece(new Position(0, 3), new Pawn(true)); // chặn dọc

        Move move = new Move(start, new Position(0, 5)); // a1 -> a6
        assertFalse(rook.canMove(board, move));
    }

    @Test
    void testRookCaptureOpponent() {
        Board board = new Board();
        Rook rook = new Rook(true);
        Position start = new Position(0, 0);
        board.setPiece(start, rook);

        Position target = new Position(0, 5);
        board.setPiece(target, new Pawn(false)); // đối thủ

        Move move = new Move(start, target);
        assertTrue(rook.canMove(board, move));
    }

    @Test
    void testRookCannotCaptureOwnPiece() {
        Board board = new Board();
        Rook rook = new Rook(true);
        Position start = new Position(0, 0);
        board.setPiece(start, rook);

        Position target = new Position(0, 5);
        board.setPiece(target, new Pawn(true)); // đồng minh

        Move move = new Move(start, target);
        assertFalse(rook.canMove(board, move));
    }
}
