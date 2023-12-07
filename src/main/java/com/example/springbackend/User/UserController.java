package com.example.springbackend.User;

import com.example.springbackend.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "http://172.21.0.2:80")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String test() {
        return "<h1>TEST</h1>";
    }

    //GET METHODS
    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
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
