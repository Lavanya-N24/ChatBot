package org.example.chatbot.service;

import org.example.chatbot.entity.ChatMessage;
import org.example.chatbot.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public String generateResponse(String message) {

        String response = "You said: " + message;

        ChatMessage chatMessage = new ChatMessage(message, response);

        chatMessageRepository.save(chatMessage);

        return response;
    }
}