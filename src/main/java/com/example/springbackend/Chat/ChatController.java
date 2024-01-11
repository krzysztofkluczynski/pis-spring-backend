package com.example.springbackend.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    @Autowired
    private ChatService service;

    @GetMapping("/chats/{chatId}")
    public ResponseEntity<Chat> getChat(@PathVariable int chatId) {
        return ResponseEntity.ok(service.getChat(chatId));
    }

    @PostMapping("/chats/create")
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        Chat createdChat = service.saveChat(chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChat);
    }

    @GetMapping("/chats/{user1Id}/{user2Id}")
    public ResponseEntity<Chat> getChatByUsers(@PathVariable int user1Id,
                                                          @PathVariable int user2Id) {
        return ResponseEntity.ok(service.getChatByUsers(user1Id, user2Id));
    }
}
