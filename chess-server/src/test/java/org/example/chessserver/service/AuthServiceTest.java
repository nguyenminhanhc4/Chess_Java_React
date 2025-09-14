package org.example.chessserver.service;

import org.example.chessserver.auth.JwtUtil;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepo;
    @Mock private PasswordEncoder encoder;
    @Mock private JwtUtil jwtUtil;

    @InjectMocks
    private AuthService authService;

    @Test
    void testRegisterSuccess() {
        Mockito.when(userRepo.existsByUsername("alice")).thenReturn(false);
        Mockito.when(userRepo.existsByEmail("a@test.com")).thenReturn(false);

        User saved = new User();
        saved.setUsername("alice");
        Mockito.when(userRepo.save(Mockito.any(User.class))).thenReturn(saved);

        User result = authService.register("alice", "a@test.com", "123");

        assertEquals("alice", result.getUsername());
    }

    @Test
    void testLoginSuccess() {
        User u = new User();
        u.setUsername("bob");
        u.setPasswordHash("encoded");
        Mockito.when(userRepo.findByUsername("bob")).thenReturn(Optional.of(u));
        Mockito.when(encoder.matches("123", "encoded")).thenReturn(true);
        Mockito.when(jwtUtil.generateToken("bob")).thenReturn("token123");

        String token = authService.login("bob", "123");

        assertEquals("token123", token);
    }
}

