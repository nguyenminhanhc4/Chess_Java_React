package org.example.chessserver.user;

import org.example.chessserver.auth.UserFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testCreatePlayer() {
        Player player = (Player) UserFactory.createUser("PLAYER", "player1", "player@test.com", "pass");
        assertEquals("player1", player.getUserEntity().getUsername());
    }

    @Test
    void testCreateAdmin() {
        Admin admin = (Admin) UserFactory.createUser("ADMIN", "admin1", "admin@test.com", "pass");
        assertEquals("admin1", admin.getUserEntity().getUsername());
    }

    @Test
    void testInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserFactory.createUser("UNKNOWN", "x", "x@test.com", "pass"));
        assertTrue(exception.getMessage().contains("Unknown user type"));
    }
}
