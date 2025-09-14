package org.example.chessserver.service;
import org.example.chessserver.entity.Role;
import org.example.chessserver.entity.User;
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
class UserServiceTest {

    @Mock private UserRepository userRepo;
    @InjectMocks private UserService userService;

    @Test
    void testUpdateProfile() {
        User u = new User();
        u.setId(1);
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(u));
        Mockito.when(userRepo.save(u)).thenReturn(u);

        User result = userService.updateProfile(1, "avatar.png", "hello");
        assertEquals("avatar.png", result.getAvatar());
        assertEquals("hello", result.getBio());
    }

    @Test
    void testBanUser() {
        User u = new User();
        u.setId(1);
        u.setRole(Role.PLAYER);
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(u));

        userService.banUser(1);

        assertEquals(Role.BANNED, u.getRole());
    }
}

