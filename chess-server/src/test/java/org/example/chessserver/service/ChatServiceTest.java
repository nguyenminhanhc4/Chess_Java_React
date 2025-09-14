package org.example.chessserver.service;

import org.example.chessserver.entity.ChatMessage;
import org.example.chessserver.entity.Game;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.ChatMessageRepository;
import org.example.chessserver.repository.GameRepository;
import org.example.chessserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ChatServiceTest {

    @Mock
    private ChatMessageRepository chatRepo;
    @Mock private GameRepository gameRepo;
    @Mock private UserRepository userRepo;

    @InjectMocks
    private ChatService chatService;

    @Test
    void testSendMessage() {
        Game g = new Game(); g.setId(1);
        User u = new User(); u.setId(2);

        Mockito.when(gameRepo.findById(1)).thenReturn(Optional.of(g));
        Mockito.when(userRepo.findById(2)).thenReturn(Optional.of(u));

        chatService.sendMessage(1, 2, "Hello!");

        Mockito.verify(chatRepo).save(Mockito.any(ChatMessage.class));
    }

    @Test
    void testGetMessages() {
        Mockito.when(chatRepo.findByGameIdOrderBySentAtAsc(1)).thenReturn(List.of(new ChatMessage()));
        List<ChatMessage> msgs = chatService.getMessages(1);

        assertEquals(1, msgs.size());
    }
}

