package org.example.chessserver.service;

import org.example.chessserver.entity.User;
import org.example.chessserver.entity.Role;
import org.example.chessserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public User getProfile(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User updateProfile(Integer id, String avatar, String bio) {
        User u = userRepository.findById(id).orElseThrow();
        u.setAvatar(avatar);
        u.setBio(bio);
        return userRepository.save(u);
    }

    public void banUser(Integer id) {
        User u = userRepository.findById(id).orElseThrow();
        u.setRole(Role.BANNED); // hoặc cờ trạng thái khác
        userRepository.save(u);
    }
}

