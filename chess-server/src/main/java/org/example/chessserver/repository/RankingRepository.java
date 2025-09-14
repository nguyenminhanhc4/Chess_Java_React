package org.example.chessserver.repository;

import org.example.chessserver.entity.Ranking;
import org.example.chessserver.entity.RankingType;
import org.example.chessserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Integer> {
    Optional<Ranking> findByPlayerAndType(User player, RankingType type);
    List<Ranking> findByTypeOrderByScoreDesc(RankingType type);
}
