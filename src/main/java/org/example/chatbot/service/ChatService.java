package org.example.chatbot.service;

import org.example.chatbot.entity.ChatMessage;
import org.example.chatbot.repository.ChatMessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public List<ChatMessage> getChatHistory() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage getChatById(Long id) {
        return chatMessageRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Chat with ID " + id + " not found"
                        )
                );
    }

    public ChatMessage updateChat(Long id, String message) {

        ChatMessage chatMessage = chatMessageRepository.findById(id)
                .orElseThrow();

        String response = "You said: " + message;

        chatMessage.setMessage(message);
        chatMessage.setResponse(response);

        return chatMessageRepository.save(chatMessage);
    }

    public void deleteChat(Long id) {
        chatMessageRepository.deleteById(id);
    }
}