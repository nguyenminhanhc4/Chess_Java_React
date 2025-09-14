package org.example.chessserver.user.builder;

import org.example.chessserver.entity.User;
import org.example.chessserver.user.Player;
import org.example.chessserver.user.Admin;

public class UserBuilder {

    private User userEntity;
    private boolean isAdmin = false;
    private int eloScore = 1000; // default
    private int gamesPlayed = 0;

    public UserBuilder() {
        this.userEntity = new User();
    }

    // Thiết lập username
    public UserBuilder setUsername(String username) {
        userEntity.setUsername(username);
        return this;
    }

    // Thiết lập email
    public UserBuilder setEmail(String email) {
        userEntity.setEmail(email);
        return this;
    }

    // Thiết lập password hash
    public UserBuilder setPasswordHash(String passwordHash) {
        userEntity.setPasswordHash(passwordHash);
        return this;
    }

    // Thiết lập role
    public UserBuilder setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
        if(isAdmin) userEntity.setRole(org.example.chessserver.entity.Role.ADMIN);
        else userEntity.setRole(org.example.chessserver.entity.Role.PLAYER);
        return this;
    }

    // Thiết lập ELO (chỉ áp dụng cho Player)
    public UserBuilder setEloScore(int eloScore) {
        this.eloScore = eloScore;
        return this;
    }

    // Thiết lập số trận đã chơi (Player)
    public UserBuilder setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        return this;
    }

    // Build object Player/Admin
    public Object build() {
        if(isAdmin) {
            return new Admin(userEntity);
        } else {
            Player player = new Player(userEntity);
            player.updateElo(eloScore);
            for(int i = 0; i < gamesPlayed; i++) {
                player.incrementGamesPlayed();
            }
            return player;
        }
    }

    // Trả về entity nếu cần
    public User buildEntity() {
        return userEntity;
    }
}