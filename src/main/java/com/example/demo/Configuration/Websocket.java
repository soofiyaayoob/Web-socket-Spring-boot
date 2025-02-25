package com.example.demo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class Websocket implements WebSocketMessageBrokerConfigurer{
	 @Override
	    public void configureMessageBroker(MessageBrokerRegistry config) {
	        config.enableSimpleBroker("/topic"); // Enables in-memory message broker
	        config.setApplicationDestinationPrefixes("/app"); // Prefix for client messages or any url
	    }

	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
	    	registry.addEndpoint("/soofiya").withSockJS();//this for if the connection failed 
	                                                          //itwill connect through http 
	    	//set allwoed orgins("*") //what is host or port client will run for now everyone access the backend
	    }
}
