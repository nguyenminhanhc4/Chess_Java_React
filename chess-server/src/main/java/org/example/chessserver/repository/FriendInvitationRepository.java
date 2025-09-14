package org.example.chessserver.repository;

import org.example.chessserver.entity.FriendInvitation;
import org.example.chessserver.entity.InvitationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FriendInvitationRepository extends JpaRepository<FriendInvitation, Integer> {
    Optional<FriendInvitation> findByPlayerIdAndFriendId(Integer playerId, Integer friendId);
    List<FriendInvitation> findByFriendIdAndStatus(Integer friendId, InvitationStatus status);
    List<FriendInvitation> findByPlayerId(Integer playerId);
}