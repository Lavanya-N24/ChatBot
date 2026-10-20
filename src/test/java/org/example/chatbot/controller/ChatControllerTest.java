 package org.example.chatbot.controller;

import org.example.chatbot.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.http.MediaType.APPLICATION_JSON;

    @WebMvcTest(ChatController.class)
    class ChatControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockitoBean
        private ChatService chatService;

        @Test
        void chat_shouldReturnSuccessfulResponse() throws Exception {

            when(chatService.generateResponse("Hello"))
                    .thenReturn("You said: Hello");

            mockMvc.perform(post("/chat")
                            .contentType(APPLICATION_JSON)
                            .content("""
                                {
                                    "message": "Hello"
                                }
                                """))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.response")
                            .value("You said: Hello"));
        }
        @Test
        void chat_withEmptyMessage_shouldReturnBadRequest() throws Exception {

            mockMvc.perform(post("/chat")
                            .contentType(APPLICATION_JSON)
                            .content("""
                            {
                                "message": ""
                            }
                            """))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Message cannot be empty"));
        }
    }

