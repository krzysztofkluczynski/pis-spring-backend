package com.example.springbackend.Chat;

import com.example.springbackend.Message.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Chat findByuser1IdAnduser2IdOruser2IdAnduser1IdLimitOne(int user1Id, int user2Id, int user2Idsecond, int user1second);
}
