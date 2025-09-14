package org.example.chessserver.service;

import org.example.chessserver.entity.User;
import org.example.chessserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AdminServiceTest {

    @Test
    void testLockUnlockUser() {
        UserRepository repo = Mockito.mock(UserRepository.class);
        AdminService service = new AdminService(repo);

        User user = new User();
        user.setUsername("player1");
        user.setRole( org.example.chessserver.entity.Role.PLAYER);

        Mockito.when(repo.findByUsername("player1")).thenReturn(Optional.of(user));
        Mockito.when(repo.save(Mockito.any())).thenReturn(user);

        service.lockUser("player1"); // không throw exception
        service.unlockUser("player1"); // không throw exception

        Mockito.verify(repo, Mockito.times(2)).save(user);
    }

    @Test
    void testUserNotFound() {
        UserRepository repo = Mockito.mock(UserRepository.class);
        AdminService service = new AdminService(repo);

        Mockito.when(repo.findByUsername("unknown")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.lockUser("unknown"));
    }
}
