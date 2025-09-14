package org.example.chessserver.service;


import org.example.chessserver.entity.Game;
import org.example.chessserver.entity.GameState;
import org.example.chessserver.entity.MoveHistory;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.GameRepository;
import org.example.chessserver.repository.MoveHistoryRepository;
import org.example.chessserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final MoveHistoryRepository moveHistoryRepository;
    private final UserRepository userRepository;

    public GameService(GameRepository gameRepository,
                       MoveHistoryRepository moveHistoryRepository,
                       UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.moveHistoryRepository = moveHistoryRepository;
        this.userRepository = userRepository;
    }

    public Game createGame(Integer whiteId, Integer blackId) {
        User white = userRepository.findById(whiteId).orElseThrow();
        User black = userRepository.findById(blackId).orElseThrow();

        Game g = new Game();
        g.setPlayerWhite(white);
        g.setPlayerBlack(black);
        g.setState(GameState.WAITING);

        return gameRepository.save(g);
    }

    public void recordMove(Integer gameId, int moveNum, String from, String to, String piece) {
        Game game = gameRepository.findById(gameId).orElseThrow();

        MoveHistory move = new MoveHistory();
        move.setGame(game);
        move.setMoveNumber(moveNum);
        move.setFromPos(from);
        move.setToPos(to);
        move.setPiece(piece);
        moveHistoryRepository.save(move);
    }

    public List<MoveHistory> getHistory(Integer gameId) {
        return moveHistoryRepository.findByGameIdOrderByMoveNumberAsc(gameId);
    }
}

