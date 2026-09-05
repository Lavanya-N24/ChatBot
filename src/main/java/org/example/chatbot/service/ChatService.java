package org.example.chatbot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {
    public String generateResponse(String message){
        return "you said:" +message;
    }


}
