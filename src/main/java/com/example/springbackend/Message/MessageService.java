package com.example.springbackend.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public Message saveMessage(Message message) {
        return repository.save(message);
    }

    public List<Message> getMessagesbySenderRecipient(int senderId, int recipientId) {
        return repository.findBySenderIdAndRecipientId(senderId, recipientId);
    }


    public List<Message> getAllMessagesInChat(int firstUserId, int secondUserId) {
        return repository.findBySenderIdAndRecipientIdOrSenderIdAndRecipientIdOrderByTimestampAsc(
                firstUserId, secondUserId, secondUserId, firstUserId);
    }
}
