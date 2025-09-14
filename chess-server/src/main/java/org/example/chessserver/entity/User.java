package org.example.chessserver.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.PLAYER;

    private String avatar;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Optional relationships
    @OneToMany(mappedBy = "playerWhite")
    private List<Game> whiteGames;

    @OneToMany(mappedBy = "playerBlack")
    private List<Game> blackGames;

    @OneToMany(mappedBy = "player")
    private List<Ranking> rankings;

    @OneToMany(mappedBy = "player")
    private List<FriendInvitation> sentInvitations;

    @OneToMany(mappedBy = "friend")
    private List<FriendInvitation> receivedInvitations;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Game> getWhiteGames() {
        return whiteGames;
    }

    public void setWhiteGames(List<Game> whiteGames) {
        this.whiteGames = whiteGames;
    }

    public List<Game> getBlackGames() {
        return blackGames;
    }

    public void setBlackGames(List<Game> blackGames) {
        this.blackGames = blackGames;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public List<FriendInvitation> getSentInvitations() {
        return sentInvitations;
    }

    public void setSentInvitations(List<FriendInvitation> sentInvitations) {
        this.sentInvitations = sentInvitations;
    }

    public List<FriendInvitation> getReceivedInvitations() {
        return receivedInvitations;
    }

    public void setReceivedInvitations(List<FriendInvitation> receivedInvitations) {
        this.receivedInvitations = receivedInvitations;
    }
}
