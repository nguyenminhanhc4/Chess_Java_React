package org.example.chessserver.game;

public class Board {
    private Piece[][] grid = new Piece[8][8]; // 8x8

    public Piece getPiece(Position pos) {
        return grid[pos.getY()][pos.getX()];
    }

    public void setPiece(Position pos, Piece piece) {
        grid[pos.getY()][pos.getX()] = piece;
    }

    public boolean isEmpty(Position pos) {
        return getPiece(pos) == null;
    }

    public Board(Board other) {
        this.grid = new Piece[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                this.grid[y][x] = other.grid[y][x]; // shallow copy
            }
        }
    }

    public boolean hasOpponentPiece(Position pos, boolean isWhite) {
        Piece p = getPiece(pos);
        return p != null && p.isWhite() != isWhite;
    }

    /** Kiểm tra đường đi có trống không (dùng cho Rook/Bishop/Queen) */
    public boolean isPathClear(Position from, Position to) {
        int dx = Integer.compare(to.getX(), from.getX());
        int dy = Integer.compare(to.getY(), from.getY());

        int x = from.getX() + dx;
        int y = from.getY() + dy;

        while (x != to.getX() || y != to.getY()) {
            if (grid[y][x] != null) return true;
            x += dx;
            y += dy;
        }
        return false;
    }

    /** Thực hiện 1 nước đi (giả định hợp lệ) */
    public void applyMove(Move move) {
        Piece piece = getPiece(move.getFrom());
        setPiece(move.getTo(), piece);
        setPiece(move.getFrom(), null);
    }
}

