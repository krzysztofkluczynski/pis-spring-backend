package com.example.springbackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //POST METHODS
    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    //GET METHODS
    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public User getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    //DELETE METHODS
    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    //PUT METHODS
    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(user);
        existingUser.setAge(user.getAge());
        existingUser.setName(user.getName());
        existingUser.setLogin(user.getLogin());
        existingUser.setSurname(user.getSurname());
        return repository.save(existingUser);
    }



}
