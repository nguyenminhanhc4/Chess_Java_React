CREATE TABLE param (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       `key` VARCHAR(100) NOT NULL,
                       `value` VARCHAR(255) NOT NULL,
                       description TEXT,
                       UNIQUE(`key`)
);

CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL UNIQUE,
                      email VARCHAR(100) NOT NULL UNIQUE,
                      password_hash VARCHAR(255) NOT NULL,
                      role ENUM('PLAYER','ADMIN') NOT NULL DEFAULT 'PLAYER',
                      avatar VARCHAR(255),
                      bio TEXT,
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                      updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE game (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      player_white_id INT NOT NULL,
                      player_black_id INT NOT NULL,
                      state ENUM('WAITING','IN_PROGRESS','FINISHED') NOT NULL DEFAULT 'WAITING',
                      result ENUM('WHITE_WIN','BLACK_WIN','DRAW'),
                      start_time DATETIME,
                      end_time DATETIME,
                      time_mode ENUM('BLITZ','RAPID','CLASSICAL') DEFAULT 'CLASSICAL',
                      FOREIGN KEY (player_white_id) REFERENCES user(id),
                      FOREIGN KEY (player_black_id) REFERENCES user(id)
);

CREATE TABLE move_history (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              game_id INT NOT NULL,
                              move_number INT NOT NULL,
                              from_pos VARCHAR(5) NOT NULL,
                              to_pos VARCHAR(5) NOT NULL,
                              piece VARCHAR(20) NOT NULL,
                              created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE
);

CREATE TABLE ranking (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         player_id INT NOT NULL,
                         type ENUM('ELO','WEEKLY','MONTHLY') NOT NULL,
                         score INT DEFAULT 0,
                         last_updated DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (player_id) REFERENCES user(id)
);

CREATE TABLE friend_invitation (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   player_id INT NOT NULL,
                                   friend_id INT NOT NULL,
                                   status ENUM('PENDING','ACCEPTED','REJECTED') DEFAULT 'PENDING',
                                   created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                   FOREIGN KEY (player_id) REFERENCES user(id),
                                   FOREIGN KEY (friend_id) REFERENCES user(id),
                                   UNIQUE(player_id, friend_id)
);

CREATE TABLE chat_message (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              game_id INT NOT NULL,
                              sender_id INT NOT NULL,
                              message TEXT NOT NULL,
                              sent_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
                              FOREIGN KEY (sender_id) REFERENCES user(id)
);
