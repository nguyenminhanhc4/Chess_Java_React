package org.example.chessserver.service;

import org.example.chessserver.entity.Ranking;
import org.example.chessserver.entity.RankingType;
import org.example.chessserver.repository.RankingRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class RankingService {
    protected final RankingRepository rankingRepository;
    public RankingService(RankingRepository rankingRepository) { this.rankingRepository = rankingRepository; }

    public abstract void updateRanking(Integer playerId, boolean win);
}

