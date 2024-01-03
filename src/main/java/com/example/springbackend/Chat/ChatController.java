package com.example.springbackend.Chat;

import com.example.springbackend.Message.Message;
import com.example.springbackend.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

//@Controller
//public class ChatController {
//
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    private UserService userService;
//
//    @MessageMapping("/message") //
//    @SendTo("/chatroom/public")
//    public Message receiveMessage(@Payload Message message){
//        return message;
//    }
//
//    @MessageMapping("/private-message")
//    public Message recMessage(@Payload Message message){
//        simpMessagingTemplate.convertAndSendToUser(userService.getUser(message.getRecipientId()).getLogin(),"/private",message);  // /user/user_login/private
//        System.out.println(message.toString());
//        return message;
//    }
//}