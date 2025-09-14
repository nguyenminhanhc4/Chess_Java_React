package org.example.chessserver.service;

import org.example.chessserver.entity.FriendInvitation;
import org.example.chessserver.entity.InvitationStatus;
import org.example.chessserver.entity.User;
import org.example.chessserver.repository.FriendInvitationRepository;
import org.example.chessserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    private final FriendInvitationRepository repo;
    private final UserRepository userRepo;

    public FriendService(FriendInvitationRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public void sendInvitation(Integer fromId, Integer toId) {
        User from = userRepo.findById(fromId).orElseThrow();
        User to = userRepo.findById(toId).orElseThrow();

        if (repo.findByPlayerAndFriend(from, to).isPresent()) {
            throw new RuntimeException("Already invited");
        }

        FriendInvitation inv = new FriendInvitation();
        inv.setPlayer(from);
        inv.setFriend(to);
        inv.setStatus(InvitationStatus.PENDING);
        repo.save(inv);
    }

    public void respondInvitation(Integer invitationId, InvitationStatus status) {
        FriendInvitation inv = repo.findById(invitationId).orElseThrow();
        inv.setStatus(status);
        repo.save(inv);
    }

    public List<FriendInvitation> getPendingInvitations(Integer userId) {
        User u = userRepo.findById(userId).orElseThrow();
        return repo.findByFriendAndStatus(u, InvitationStatus.PENDING);
    }
}


