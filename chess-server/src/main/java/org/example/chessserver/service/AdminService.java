package org.example.chessserver.service;

import org.example.chessserver.entity.User;
import org.example.chessserver.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void lockUser(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            // giả sử khóa bằng cách đổi role hoặc thêm flag
            user.setRole(user.getRole()); // tùy logic của bạn
            userRepository.save(user);
            System.out.println("User locked: " + username);
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }

    public void unlockUser(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            // mở khóa
            user.setRole(user.getRole()); // tùy logic
            userRepository.save(user);
            System.out.println("User unlocked: " + username);
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }

    // Xem log trận đấu (placeholder)
    public void viewGameLogs() {
        System.out.println("Viewing all game logs...");
    }
}
