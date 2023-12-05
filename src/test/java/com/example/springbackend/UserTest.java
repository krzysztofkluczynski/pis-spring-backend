package com.example.springbackend;

import com.example.springbackend.User.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    @Test
    void getNameCreatedInConstructorTest() {
        User u = new User(1, "klkuczyn", "Krzysztof", "Kluczyński", 21);
        assertEquals(1, u.getId());
    }

    @Test
    void setNameTest() {
        User u = new User(1, "jfilpec", "Jan", "Filipecki", 22);
        u.setName("Kacper");
        assertEquals("Kacper", u.getName());
    }

    @Test
    void emptyUserTest() {
        User u = new User();
        assertNull(u.getName());
    }
}