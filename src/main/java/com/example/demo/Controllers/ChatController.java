package com.example.demo.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.ChatMessage;

@Controller
public class ChatController {
	 @MessageMapping("/send")
	    @SendTo("/topic/messages") 
	    public String sendMessage(String message) {
		 System.out.println(message);
	        return "Broadcast: " + message;
	    }
	 
	 @MessageMapping("/chat.register")
		@SendTo("/topic/public")
		public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
			headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
			return chatMessage;
		}

		@MessageMapping("/chat.send")
		@SendTo("/topic/public")
		public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
			return chatMessage;
		}
}
