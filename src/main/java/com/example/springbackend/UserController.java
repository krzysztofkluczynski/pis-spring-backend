package com.example.springbackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public User greetUser(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new User(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("")
    public String hello() {
        return "<h1>Hello from default page :////<h1>";
    }

}
