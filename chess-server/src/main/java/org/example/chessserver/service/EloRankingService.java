package org.example.chessserver.service;

import org.example.chessserver.entity.User;
import org.example.chessserver.entity.Ranking;
import org.example.chessserver.entity.RankingType;
import org.example.chessserver.repository.RankingRepository;
import org.example.chessserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EloRankingService extends RankingService {
    private final UserRepository userRepository;

    public EloRankingService(RankingRepository repo, UserRepository userRepository) {
        super(repo);
        this.userRepository = userRepository;
    }

    @Override
    public void updateRanking(Integer playerId, boolean win) {
        User player = userRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Ranking r = rankingRepository.findByPlayerAndType(player, RankingType.ELO)
                .orElse(new Ranking(player, RankingType.ELO, 1000));
        r.setScore(r.getScore() + (win ? 15 : -10));
        rankingRepository.save(r);
    }
}
