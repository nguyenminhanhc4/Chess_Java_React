package org.example.chessserver.repository;

import org.example.chessserver.entity.Game;
import org.example.chessserver.entity.GameState;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByPlayerWhiteIdOrPlayerBlackId(Integer playerWhiteId, Integer playerBlackId);
    List<Game> findByState(GameState state);
    // Ví dụ: lấy các ván đang in-progress của 1 player
    List<Game> findByStateAndPlayerWhiteIdOrStateAndPlayerBlackId(GameState s1, Integer p1, GameState s2, Integer p2);
}
