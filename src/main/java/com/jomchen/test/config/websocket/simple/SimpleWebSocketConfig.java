package com.jomchen.test.config.websocket.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * create by Jomchen on 12/27/18
 */
@Component
@EnableWebSocket
public class SimpleWebSocketConfig implements WebSocketConfigurer{

    @Autowired
    private SimpleWebSocketInterceptor simpleWebSocketInterceptor;
    @Autowired
    private SimpleWebSocketHandler simpleWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(simpleWebSocketHandler, "/myHandler")
                .addInterceptors(simpleWebSocketInterceptor)
                ;
    }

}
