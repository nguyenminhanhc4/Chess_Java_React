package org.example.chessserver.user;

import org.example.chessserver.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void testPlayerCreationAndMethods() {
        User user = new User();
        user.setUsername("player1");
        user.setEmail("player1@test.com");

        Player player = new Player(user);

        assertEquals("player1", player.getUserEntity().getUsername());
        assertEquals(1000, player.getEloScore());
        assertEquals(0, player.getGamesPlayed());

        // Test incrementGamesPlayed
        player.incrementGamesPlayed();
        assertEquals(1, player.getGamesPlayed());

        // Test addFriend
        player.addFriend(2);
        assertTrue(player.getFriendIds().contains(2));

        // Test updateElo
        player.updateElo(1200);
        assertEquals(1200, player.getEloScore());
    }
}
