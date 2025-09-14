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
}