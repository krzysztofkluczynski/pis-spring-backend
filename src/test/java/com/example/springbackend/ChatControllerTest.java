package com.example.springbackend;

//
import com.example.springbackend.Chat.Chat;
import com.example.springbackend.Chat.ChatController;
import com.example.springbackend.Chat.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ChatControllerTest {

    @Mock
    private ChatService service;

    @InjectMocks
    private ChatController controller;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Test
    public void testGetChat() throws Exception {
        // Arrange
        int chatId = 1;
        Chat mockChat = new Chat();
        when(service.getChat(chatId)).thenReturn(mockChat);

        // Act & Assert
        mockMvc.perform(get("/chats/{chatId}", chatId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming Chat has an 'id' field

        // Verify
        verify(service, times(1)).getChat(chatId);
    }

    @Test
    public void testCreateChat() throws Exception {
        // Arrange
        Chat newChat = new Chat();
        when(service.saveChat(any(Chat.class))).thenReturn(newChat);

        // Act & Assert
        mockMvc.perform(post("/chats/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newChat)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming Chat has an 'id' field

        // Verify
        verify(service, times(1)).saveChat(any(Chat.class));
    }

    @Test
    public void testGetChatByUsers() throws Exception {
        // Arrange
        int user1Id = 1;
        int user2Id = 2;
        Chat mockChat = new Chat();
        when(service.getChatByUsers(user1Id, user2Id)).thenReturn(mockChat);

        // Act & Assert
        mockMvc.perform(get("/chats/{user1Id}/{user2Id}", user1Id, user2Id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // assuming Chat has an 'id' field

        // Verify
        verify(service, times(1)).getChatByUsers(user1Id, user2Id);
    }




    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}


