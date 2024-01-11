package com.example.springbackend.Message;

import com.example.springbackend.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public Message createMessage(Message message) {
        return repository.save(message);
    }

    public Message getMessage(int messageId) {
        return repository.findById(messageId).orElse(null);
    }

    public List<Message> getChatMessages(int chatId) {
            return repository.findByChatId(chatId);
    }
}
