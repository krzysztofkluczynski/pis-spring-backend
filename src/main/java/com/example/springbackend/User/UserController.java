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

    //POST METHODS
    @PostMapping("/users/add")
//    @MessageMapping("/user.addUser")
//    @SendTo("/user/topic")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @PostMapping("/users/add_multiple")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users) {
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
