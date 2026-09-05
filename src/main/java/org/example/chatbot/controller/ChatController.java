package org.example.chatbot.controller;

import org.example.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, chatbot!";
    }
    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response= chatService.generateResponse(request.getMessage());
        return new ChatResponse(response);
    }

}
