package org.example.chessserver.service;

import org.example.chessserver.entity.ChatMessage;
import org.example.chessserver.repository.ChatMessageRepository;
import org.example.chessserver.repository.GameRepository;
import org.example.chessserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final ChatMessageRepository chatRepo;
    private final GameRepository gameRepo;
    private final UserRepository userRepo;

    public ChatService(ChatMessageRepository chatRepo, GameRepository gameRepo, UserRepository userRepo) {
        this.chatRepo = chatRepo;
        this.gameRepo = gameRepo;
        this.userRepo = userRepo;
    }

    public void sendMessage(Integer gameId, Integer senderId, String msg) {
        ChatMessage m = new ChatMessage();
        m.setGame(gameRepo.findById(gameId).orElseThrow());
        m.setSender(userRepo.findById(senderId).orElseThrow());
        m.setMessage(msg);
        chatRepo.save(m);
    }

    public List<ChatMessage> getMessages(Integer gameId) {
        return chatRepo.findByGameIdOrderBySentAtAsc(gameId);
    }
}

