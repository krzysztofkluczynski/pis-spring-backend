package com.example.springbackend.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/chats/{chatId}/messages")
    public ResponseEntity<List<Message>> getChatMessages(@PathVariable int chatId) {
        return ResponseEntity
                .ok(service.getChatMessages(chatId));
    }
    @PostMapping("/chats/send")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        System.out.println(message.getChatId() + "\n\n\n\n");
        Message createdMessage = service.saveMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }

}
