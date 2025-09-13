package org.example.chessserver.game;

import org.example.chessserver.game.piece.Knight;
import org.example.chessserver.game.piece.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMoveTest {
    @Test
    void testKnightValidMoves() {
        Board board = new Board();
        Position start = new Position(4, 4);
        Knight knight = new Knight(true);
        board.setPiece(start, knight);

        // đi 2 ngang 1 dọc
        Move move1 = new Move(start, new Position(6, 5));
        assertTrue(knight.canMove(board, move1));

        // đi 2 dọc 1 ngang
        Move move2 = new Move(start, new Position(5, 6));
        assertTrue(knight.canMove(board, move2));
    }

    @Test
    void testKnightInvalidMove() {
        Board board = new Board();
        Position start = new Position(4, 4);
        Knight knight = new Knight(true);
        board.setPiece(start, knight);

        // đi thẳng 1 ô (sai)
        Move move = new Move(start, new Position(4, 5));
        assertFalse(knight.canMove(board, move));
    }

    @Test
    void testKnightCanCaptureOpponent() {
        Board board = new Board();
        Position start = new Position(4, 4);
        Knight knight = new Knight(true);
        board.setPiece(start, knight);

        // quân đối thủ ở vị trí L
        Position target = new Position(6, 5);
        board.setPiece(target, new Pawn(false));

        Move move = new Move(start, target);
        assertTrue(knight.canMove(board, move));
    }

    @Test
    void testKnightCannotCaptureOwnPiece() {
        Board board = new Board();
        Position start = new Position(4, 4);
        Knight knight = new Knight(true);
        board.setPiece(start, knight);

        // quân đồng minh ở vị trí L
        Position target = new Position(6, 5);
        board.setPiece(target, new Pawn(true));

        Move move = new Move(start, target);
        assertFalse(knight.canMove(board, move));
    }
}
