package org.example.chessserver.repository;

import org.example.chessserver.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {
    List<ChatMessage> findByGameIdOrderBySentAtAsc(Integer gameId);
    void deleteByGameId(Integer gameId);
}
