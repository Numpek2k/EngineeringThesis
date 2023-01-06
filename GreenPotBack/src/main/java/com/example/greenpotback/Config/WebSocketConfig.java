package com.example.greenpotback.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/message/get").setAllowedOrigins("*");
//        registry.addEndpoint("/secured/room").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue" ,"/user");
        registry.setApplicationDestinationPrefixes("/app");
//        registry.enableSimpleBroker("/secured/user/queue/specific-user");
//        registry.setApplicationDestinationPrefixes("/spring-security-mvc-socket");
//        registry.setUserDestinationPrefix("/secured/user");
    }
}