package org.example.chessserver.user;

import org.example.chessserver.entity.User;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final User userEntity; // reference tới entity User

    // Thông tin game
    private int eloScore;
    private int gamesPlayed;
    private List<Integer> friendIds; // hoặc List<Player> nếu muốn link object trực tiếp

    public Player(User userEntity) {
        this.userEntity = userEntity;
        this.eloScore = 1000; // default ELO
        this.gamesPlayed = 0;
        this.friendIds = new ArrayList<>();
    }

    // Các method nghiệp vụ
    public void addFriend(int friendId) {
        if(!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

    public void updateElo(int newElo) {
        eloScore = newElo;
    }

    // Getter cho entity và các field
    public User getUserEntity() {
        return userEntity;
    }

    public int getEloScore() {
        return eloScore;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public List<Integer> getFriendIds() {
        return friendIds;
    }

}
