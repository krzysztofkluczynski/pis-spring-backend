package com.example.springbackend.Message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "chatid")
    private int chatId;

    @Column(name = "userid")
    private int userId;

    @Column(name="content")
    private String content;

    @Column(name = "\"timestamp\"")
    @CreationTimestamp
    private LocalDateTime timestamp;

//    public Message(int chatId, int userId, String content, LocalDateTime timestamp) {
//        this.chatId = chatId;
//        this.userId = userId;
//        this.content = content;
//        this.timestamp = timestamp;
//    }
}
