package org.example.chessserver.service;

import org.example.chessserver.entity.Ranking;
import org.example.chessserver.entity.RankingType;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.RankingRepository;
import org.example.chessserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EloRankingServiceTest {

    @Mock
    private RankingRepository rankingRepo;
    @Mock
    private UserRepository userRepo;

    @InjectMocks private EloRankingService eloService;

    @Test
    void testUpdateRankingWin() {
        User u = new User(); u.setId(1);
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(u));
        Mockito.when(rankingRepo.findByPlayerAndType(u, RankingType.ELO)).thenReturn(Optional.empty());

        eloService.updateRanking(1, true);

        Mockito.verify(rankingRepo).save(Mockito.any(Ranking.class));
    }

    @Test
    void testUpdateRankingLose() {
        User u = new User(); u.setId(1);
        Ranking r = new Ranking(u, RankingType.ELO, 1000);

        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(u));
        Mockito.when(rankingRepo.findByPlayerAndType(u, RankingType.ELO)).thenReturn(Optional.of(r));

        eloService.updateRanking(1, false);

        assertEquals(990, r.getScore());
    }
}

