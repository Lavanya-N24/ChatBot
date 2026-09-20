package org.example.chatbot.controller;
import org.example.chatbot.entity.ChatMessage;
import java.util.List;
import org.example.chatbot.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ChatResponse> chat(
            @Valid @RequestBody ChatRequest request) {

        String response = chatService.generateResponse(request.getMessage());

        return ResponseEntity.ok(
                new ChatResponse(response)
        );
    }
    @GetMapping("/chat/history")
    public List<ChatMessage> getChatHistory() {
        return chatService.getChatHistory();
    }
    @GetMapping("/chat/{id}")
    public ChatMessage getChatById(@PathVariable Long id) {
        return chatService.getChatById(id);
    }
    @PutMapping("/chat/{id}")
    public ChatMessage updateChat(
            @PathVariable Long id,
            @RequestBody UpdateChatRequest request) {

        return chatService.updateChat(id, request.getMessage());
    }
    @DeleteMapping("/chat/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
        chatService.deleteChat(id);

        return ResponseEntity.noContent().build();
    }

}

