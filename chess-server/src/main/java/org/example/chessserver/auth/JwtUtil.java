package org.example.chessserver.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
public class JwtUtil {

    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(
            "my-super-secret-key-32-bytes-long!".getBytes()
    );
    private static final long EXPIRATION_MS = 86400000; // 1 ngày

    private static JwtUtil instance;

    private JwtUtil() {}

    public static JwtUtil getInstance() {
        if(instance == null) {
            instance = new JwtUtil();
        }
        return instance;
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
