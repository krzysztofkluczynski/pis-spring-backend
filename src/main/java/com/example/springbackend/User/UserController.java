package com.example.springbackend.User;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String test() {
        return "<h1>TEST</h1>";
    }

    //GET METHODS
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @GetMapping("/users/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getUserByName(name));
    }

    @GetMapping("/users/login/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok(service.getUserByLogin(login));
    }

    //POST METHODS
    @PostMapping("/users/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @PostMapping("/users/create_multiple")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
        return ResponseEntity.ok(service.saveUsers(users));
    }

    //PUT METHODS
    @PutMapping("/users/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(service.updateUser(user));
    }

    //DELETE METHODS
    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }



}
