package com.example.springbackend;

import com.example.springbackend.User.User;
import com.example.springbackend.User.UserController;
import com.example.springbackend.User.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService service;


    @InjectMocks
    private UserController controller;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Test
    public void testTest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("<h1>TEST</h1>"));
    }

    @Test
    public void testGetUsers() throws Exception {
        // Arrange
        List<User> mockUsers = Arrays.asList(new User(), new User());
        when(service.getUsers()).thenReturn(mockUsers);

        // Act & Assert
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))); // assuming there are two users in the list

        // Verify
        verify(service, times(1)).getUsers();
    }

    @Test
    public void testGetUserById() throws Exception {
        // Arrange
        int userId = 1;
        User mockUser = new User();
        when(service.getUser(userId)).thenReturn(mockUser);

        // Act & Assert
        mockMvc.perform(get("/users/id/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming User has an 'id' field

        // Verify
        verify(service, times(1)).getUser(userId);
    }

    // Similar tests for other methods can be added following the same structure
    @Test
    public void testGetUserByName() throws Exception {
        // Arrange
        String userName = "JohnDoe";
        User mockUser = new User();
        when(service.getUserByName(userName)).thenReturn(mockUser);

        // Act & Assert
        mockMvc.perform(get("/users/name/{name}", userName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming User has an 'id' field

        // Verify
        verify(service, times(1)).getUserByName(userName);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        // Arrange
        String userLogin = "john.doe";
        List<User> mockUsers = Arrays.asList(new User(), new User());
        when(service.getUserByLogin(userLogin)).thenReturn(mockUsers);

        // Act & Assert
        mockMvc.perform(get("/users/login/{login}", userLogin))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))); // assuming there are two users in the list

        // Verify
        verify(service, times(1)).getUserByLogin(userLogin);
    }

    @Test
    public void testCreateUser() throws Exception {
        // Arrange
        User newUser = new User();
        when(service.saveUser(any(User.class))).thenReturn(newUser);

        // Act & Assert
        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming User has an 'id' field

        // Verify
        verify(service, times(1)).saveUser(any(User.class));
    }

    @Test
    public void testCreateUsers() throws Exception {
        // Arrange
        List<User> newUsers = Arrays.asList(new User(), new User());
        when(service.saveUsers(anyList())).thenReturn(newUsers);

        // Act & Assert
        mockMvc.perform(post("/users/create_multiple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUsers)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))); // assuming there are two users in the list

        // Verify
        verify(service, times(1)).saveUsers(anyList());
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Arrange
        User updatedUser = new User();
        when(service.updateUser(any(User.class))).thenReturn(updatedUser);

        // Act & Assert
        mockMvc.perform(put("/users/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming User has an 'id' field

        // Verify
        verify(service, times(1)).updateUser(any(User.class));
    }

    @Test
    public void testDeleteUser() throws Exception {
        // Arrange
        int userId = 1;

        // Act & Assert
        mockMvc.perform(delete("/users/delete/{id}", userId))
                .andExpect(status().isOk());

        // Verify
        verify(service, times(1)).deleteUser(userId);
    }
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}
