package com.example.springbackend.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    List<User> findByLogin(String login);

}
