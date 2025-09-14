package org.example.chessserver.user;

import org.example.chessserver.user.builder.UserBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserBuilderTest {

    @Test
    void testBuildPlayer() {
        Player player = (Player) new UserBuilder()
                .setUsername("player1")
                .setEmail("player1@test.com")
                .setPasswordHash("hashedpass")
                .setEloScore(1300)
                .setGamesPlayed(3)
                .build();

        assertEquals("player1", player.getUserEntity().getUsername());
        assertEquals(1300, player.getEloScore());
        assertEquals(3, player.getGamesPlayed());
    }

    @Test
    void testBuildAdmin() {
        Admin admin = (Admin) new UserBuilder()
                .setUsername("admin1")
                .setEmail("admin@test.com")
                .setPasswordHash("hashedpass")
                .setAdmin(true)
                .build();

        assertEquals("admin1", admin.getUserEntity().getUsername());
    }
}
