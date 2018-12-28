package com.jomchen.test.config.websocket.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * create by Jomchen on 12/27/18
 */
@Configuration
@EnableWebSocket
public class SimpleWebSocketConfig implements WebSocketConfigurer{

    @Autowired
    private SimpleWebSocketInterceptor simpleWebSocketInterceptor;
    @Autowired
    private SimpleWebSocketHandshake simpleWebSocketHandshake;
    @Autowired
    private SimpleWebSocketHandler simpleWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(simpleWebSocketHandler, "/simpleWebSocket")
                .setAllowedOrigins("*")
                .addInterceptors(
                        new HttpSessionHandshakeInterceptor(),
                        simpleWebSocketInterceptor
                )
                .setHandshakeHandler(simpleWebSocketHandshake)
                /*.withSockJS()*/
                ;
    }

    @Bean
    public ServletServerContainerFactoryBean createWebsocketContainer() {
        ServletServerContainerFactoryBean container =
                new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }

}
