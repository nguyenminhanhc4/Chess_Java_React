package org.example.chessserver.repository;

import org.example.chessserver.entity.FriendInvitation;
import org.example.chessserver.entity.InvitationStatus;
import org.example.chessserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FriendInvitationRepository extends JpaRepository<FriendInvitation, Integer> {
    Optional<FriendInvitation> findByPlayerAndFriend(User player, User friend);
    List<FriendInvitation> findByFriendAndStatus(User friend, InvitationStatus status);
    List<FriendInvitation> findByPlayer(User player);
}