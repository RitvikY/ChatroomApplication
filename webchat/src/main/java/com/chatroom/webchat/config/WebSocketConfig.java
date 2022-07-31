/* The purpose of this class is to configure the websocket endpoint and message broker */
package com.chatroom.webchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker // starts websocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // registering websocket endpoint so we can connect to websocket server
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /* sockJS will enable alternate options for browsers without websocket support */
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}