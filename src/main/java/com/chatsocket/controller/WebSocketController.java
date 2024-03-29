package com.chatsocket.controller;

import com.chatsocket.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat (@DestinationVariable String roomId, ChatMessage chatMessage) {
        return new ChatMessage(chatMessage.getMessage(), chatMessage.getUser());
    }
}
