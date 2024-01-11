package com.example.springbackend.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByLogin(String login);

}
