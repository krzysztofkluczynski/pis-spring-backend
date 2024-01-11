//package com.example.springbackend.Chat;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import java.time.LocalDateTime;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name = "chats")
//public class Chat {
//
//    @JsonIgnore
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private int senderId;
//    private int recipientId;
//
//    public Chat(int senderID, int recipientId) {
//        this.senderId = senderID;
//        this.recipientId = recipientId;
//    }
//}
