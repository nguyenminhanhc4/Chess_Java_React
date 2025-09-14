package org.example.chessserver.repository;

import org.example.chessserver.entity.MoveHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoveHistoryRepository extends JpaRepository<MoveHistory, Integer> {
    List<MoveHistory> findByGameIdOrderByMoveNumberAsc(Integer gameId);
    void deleteByGameId(Integer gameId);
}
