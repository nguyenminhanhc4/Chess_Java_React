package org.example.chessserver.user;

import org.example.chessserver.entity.User;

public class Admin {

    private User userEntity; // reference tới entity User

    public Admin(User userEntity) {
        this.userEntity = userEntity;
    }

    // Các method nghiệp vụ của admin
    public void lockUser(User user) {
        // logic khóa tài khoản
        System.out.println("Locking user: " + user.getUsername());
    }

    public void unlockUser(User user) {
        // logic mở khóa tài khoản
        System.out.println("Unlocking user: " + user.getUsername());
    }

    public void viewGameLogs() {
        // logic xem log trận đấu
        System.out.println("Viewing game logs...");
    }

    public User getUserEntity() {
        return userEntity;
    }

}
