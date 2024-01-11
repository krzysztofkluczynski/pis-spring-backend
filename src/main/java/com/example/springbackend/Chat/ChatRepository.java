package com.example.springbackend.Chat;

import com.example.springbackend.Message.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Chat findFirstByuser1IdAnduser2IdOruser2IdAnduser1Id(int user1Id, int user2Id, int user2Idsecond, int user1Idsecond);
}
