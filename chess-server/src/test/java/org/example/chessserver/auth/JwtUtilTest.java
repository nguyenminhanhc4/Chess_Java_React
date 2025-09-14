package org.example.chessserver.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    void testGenerateAndValidateToken() {
        JwtUtil jwt = JwtUtil.getInstance();
        String token = jwt.generateToken("player1");

        assertNotNull(token);
        assertTrue(jwt.validateToken(token));
        assertEquals("player1", jwt.getUsernameFromToken(token));
    }

    @Test
    void testInvalidToken() {
        JwtUtil jwt = JwtUtil.getInstance();
        assertFalse(jwt.validateToken("invalid.token.value"));
    }
}
