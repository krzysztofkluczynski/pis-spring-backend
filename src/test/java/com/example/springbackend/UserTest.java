package com.example.springbackend;

import com.example.springbackend.User.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void getNameCreatedInConstructorTest() {
        User u = new User(1, "Krzysztof");
        assertEquals(1, u.getId());
    }

    @Test
    void setNameTest() {
        User u = new User(1, "Jan");
        u.setName("Kacper");
        assertEquals("Kacper", u.getName());
    }
}