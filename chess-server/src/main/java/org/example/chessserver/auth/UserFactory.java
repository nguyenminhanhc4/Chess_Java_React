package org.example.chessserver.auth;

import org.example.chessserver.user.builder.UserBuilder;
import org.example.chessserver.user.Player;
import org.example.chessserver.user.Admin;

public class UserFactory {

    // Factory method: tạo Player hoặc Admin
    public static Object createUser(String type, String username, String email, String passwordHash) {
        if(type == null) throw new IllegalArgumentException("Type cannot be null");

        UserBuilder builder = new UserBuilder()
                .setUsername(username)
                .setEmail(email)
                .setPasswordHash(passwordHash);

        switch(type.toUpperCase()) {
            case "PLAYER":
                builder.setAdmin(false); // mặc định
                return (Player) builder.build();

            case "ADMIN":
                builder.setAdmin(true);
                return (Admin) builder.build();

            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}
