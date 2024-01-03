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

    @JsonIgnore //nie jestem pewny czy potrzebujemy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int senderId;

    private int recipientId;
    private String content;

    @Column(name = "\"timestamp\"")
    @CreationTimestamp
    private LocalDateTime timestamp;

    public Message(int senderID, int recipientId, String context, LocalDateTime timestamp) {
        this.senderId = senderID;
        this.recipientId = recipientId;
        this.content = context;
        this.timestamp = timestamp;
    }
}
