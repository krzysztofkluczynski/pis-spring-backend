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
    public Chat saveChat(Chat chat) {
        return repository.save(chat);
    }

    public Chat getChatByUsers(int user1Id, int user2Id) {
        Chat chat;
        chat = repository.findFirstByUser1IdAndUser2IdOrUser2IdAndUser1Id(user1Id, user2Id, user2Id, user1Id);
        System.out.println(chat.getId());
        return chat;
    }

    public List<Chat> getChatByOneUser(int userId) {
        return repository.findByUser1IdOrUser2Id(userId, userId);
    }


}
