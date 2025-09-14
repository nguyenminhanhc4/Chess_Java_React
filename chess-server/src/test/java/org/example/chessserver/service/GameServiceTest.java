package org.example.chessserver.service;

import org.example.chessserver.entity.Game;
import org.example.chessserver.entity.MoveHistory;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.GameRepository;
import org.example.chessserver.repository.MoveHistoryRepository;
import org.example.chessserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameRepository gameRepo;
    @Mock private MoveHistoryRepository moveRepo;
    @Mock private UserRepository userRepo;

    @InjectMocks
    private GameService gameService;

    @Test
    void testCreateGame() {
        User w = new User(); w.setId(1);
        User b = new User(); b.setId(2);
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(w));
        Mockito.when(userRepo.findById(2)).thenReturn(Optional.of(b));

        Game g = new Game();
        Mockito.when(gameRepo.save(Mockito.any(Game.class))).thenReturn(g);

        Game result = gameService.createGame(1, 2);

        assertNotNull(result);
    }

    @Test
    void testRecordMove() {
        Game g = new Game();
        g.setId(1);
        Mockito.when(gameRepo.findById(1)).thenReturn(Optional.of(g));

        MoveHistory saved = new MoveHistory();
        Mockito.when(moveRepo.save(Mockito.any(MoveHistory.class))).thenReturn(saved);

        gameService.recordMove(1, 1, "e2", "e4", "Pawn");

        Mockito.verify(moveRepo).save(Mockito.any(MoveHistory.class));
    }
}

