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

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<Message>> findChatMessages(@PathVariable int senderId,
                                                          @PathVariable int recipientId) {
        return ResponseEntity
                .ok(service.getMessagesbySenderRecipient(senderId, recipientId));
    }

    @PostMapping("/messages/create")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        System.out.println(message);
        Message createdMessage = service.saveMessage(
                message);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }

}
