package org.example.chatbot.service;
import org.example.chatbot.repository.ChatMessageRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.chatbot.entity.ChatMessage;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ChatServiceTest {
    @Mock
    private ChatMessageRepository chatMessageRepository;

    @InjectMocks
    private ChatService chatService;
    @Test
    void generateResponse() {
        String result = chatService.generateResponse("Hello");

        assertEquals("You said: Hello", result);
        verify(chatMessageRepository).save(any(ChatMessage.class));
    }
    @Test
    void generateResponse_whenSaveFails_shouldThrowException() {

        doThrow(new RuntimeException("Database error"))
                .when(chatMessageRepository)
                .save(any(ChatMessage.class));

        assertThrows(
                RuntimeException.class,
                () -> chatService.generateResponse("Hello")
        );
    }
}