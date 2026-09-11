package org.example.chatbot.controller;
import org.example.chatbot.entity.ChatMessage;
import java.util.List;
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
    @GetMapping("/chat/history")
    public List<ChatMessage> getChatHistory() {
        return chatService.getChatHistory();
    }
    @GetMapping("/chat/{id}")
    public ChatMessage getChatById(@PathVariable Long id) {
        return chatService.getChatById(id);
    }
}

