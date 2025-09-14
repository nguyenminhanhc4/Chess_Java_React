package org.example.chessserver.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "player_white_id", nullable = false)
    private User playerWhite;

    @ManyToOne
    @JoinColumn(name = "player_black_id", nullable = false)
    private User playerBlack;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameState state = GameState.WAITING;

    @Enumerated(EnumType.STRING)
    private GameResult result;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_mode")
    private TimeMode timeMode = TimeMode.CLASSICAL;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MoveHistory> moveHistories;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessage> chatMessages;

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getPlayerWhite() {
        return playerWhite;
    }

    public void setPlayerWhite(User playerWhite) {
        this.playerWhite = playerWhite;
    }

    public User getPlayerBlack() {
        return playerBlack;
    }

    public void setPlayerBlack(User playerBlack) {
        this.playerBlack = playerBlack;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameResult getResult() {
        return result;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public TimeMode getTimeMode() {
        return timeMode;
    }

    public void setTimeMode(TimeMode timeMode) {
        this.timeMode = timeMode;
    }

    public List<MoveHistory> getMoveHistories() {
        return moveHistories;
    }

    public void setMoveHistories(List<MoveHistory> moveHistories) {
        this.moveHistories = moveHistories;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }
}