//package com.example.springbackend.Chat;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ChatController {
//
//    @Autowired
//    private ChatService service;
//
//    @GetMapping("/chats/{chatId}")
//    public Chat getChat(@PathVariable int chatId) {
//        return ResponseEntity
//                .ok(service.getChat(chatId));
//    }
//
//    @GetMapping("/chats/{senderId}/{recipientId}")
//    public ResponseEntity<List<Chat>> findChat(@PathVariable int senderId,
//                                                          @PathVariable int recipientId) {
//        return ResponseEntity
//                .ok(service.getChatBySenderRecipient(senderId, recipientId));
//    }
//
//    @GetMapping("/chats/{chatId}/messages")
//    public ResponseEntity<List<Message>> getChatMessages(@PathVariable int chatId) {
//        return ResponseEntity
//                .ok(service.getChatMessages(chatId));
//    }
//
//    @PostMapping("/chats/create")
//    public ResponseEntity<Chat> createMessage(@RequestBody Message message) {
//        System.out.println(message);
//        Message createdMessage = service.saveMessage(
//                message);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
//    }
//
//}
