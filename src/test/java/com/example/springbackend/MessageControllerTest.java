package com.example.springbackend;

import com.example.springbackend.Message.Message;
import com.example.springbackend.Message.MessageController;
import com.example.springbackend.Message.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
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
public class MessageControllerTest {

    @Mock
    private MessageService service;

    @InjectMocks
    private MessageController controller;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Test
    public void testGetChatMessages() throws Exception {
        // Arrange
        int chatId = 1;
        List<Message> mockMessages = Arrays.asList(new Message(), new Message());
        when(service.getChatMessages(chatId)).thenReturn(mockMessages);

        // Act & Assert
        mockMvc.perform(get("/chats/{chatId}/messages", chatId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))); // assuming there are two messages in the list

        // Verify
        verify(service, times(1)).getChatMessages(chatId);
    }

    @Test
    public void testCreateMessage() throws Exception {
        // Arrange
        Message newMessage = new Message();
        when(service.saveMessage(any(Message.class))).thenReturn(newMessage);

        // Act & Assert
        mockMvc.perform(post("/chats/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newMessage)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Verify
        verify(service, times(1)).saveMessage(any(Message.class));
    }

    // ... (additional tests if needed)

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}
