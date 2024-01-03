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

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUser(id);
    }

    @GetMapping("/userbyname/{name}")
    public User getUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }


    //POST METHODS
    @PostMapping("/adduser")
//    @MessageMapping("/user.addUser")
//    @SendTo("/user/topic")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/addusers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    //PUT METHODS
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    //DELETE METHODS
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }



}
