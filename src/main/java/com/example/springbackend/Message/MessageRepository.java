package com.example.springbackend.Message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByChatId(int chatId);

    List<Message> findByChatIdOrderByTimestampDesc(int chatId);
}
