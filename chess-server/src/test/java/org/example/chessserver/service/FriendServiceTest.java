package org.example.chessserver.service;

import org.example.chessserver.entity.FriendInvitation;
import org.example.chessserver.entity.InvitationStatus;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.FriendInvitationRepository;
import org.example.chessserver.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FriendServiceTest {

    @Mock
    private FriendInvitationRepository repo;
    @Mock private UserRepository userRepo;
    @InjectMocks
    private FriendService friendService;

    @Test
    void testSendInvitation() {
        User from = new User(); from.setId(1);
        User to = new User(); to.setId(2);
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(from));
        Mockito.when(userRepo.findById(2)).thenReturn(Optional.of(to));
        Mockito.when(repo.findByPlayerAndFriend(from, to)).thenReturn(Optional.empty());

        friendService.sendInvitation(1, 2);

        Mockito.verify(repo).save(Mockito.any(FriendInvitation.class));
    }

    @Test
    void testRespondInvitation() {
        FriendInvitation inv = new FriendInvitation();
        inv.setStatus(InvitationStatus.PENDING);
        Mockito.when(repo.findById(10)).thenReturn(Optional.of(inv));

        friendService.respondInvitation(10, InvitationStatus.ACCEPTED);

        assertEquals(InvitationStatus.ACCEPTED, inv.getStatus());
    }
}

