package org.example.chessserver.auth;

import org.example.chessserver.user.Admin;
import org.example.chessserver.user.Player;
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
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                UserFactory.createUser("UNKNOWN", "x", "x@test.com", "pass"));
        assertTrue(ex.getMessage().contains("Unknown user type"));
    }
}
