package com.example.springbackend.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository repository;

    public Chat getChat(int chatId) {
        return repository.findById(chatId).orElse(null);
    }
    public Chat createChat(Chat chat) {
        return repository.save(chat);
    }

    public Chat getChatByUsers(int user1Id, int user2Id) {
        return repository.findByuser1IdAnduser2IdOruser2IdAnduser1IdLimitOne(user1Id, user2Id, user2Id, user1Id);
    }

}
