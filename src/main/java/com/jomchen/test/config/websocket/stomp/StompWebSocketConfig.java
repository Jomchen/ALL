package com.jomchen.test.config.websocket.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * create by Jomchen on 12/30/18
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    @Qualifier("stompWebSocketInterceptor")
    private StompWebSocketInterceptor stompWebSocketInterceptor;
    @Autowired
    @Qualifier("stompChannelInterceptor")
    private StompChannelInterceptor stompChannelInterceptor;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stompPoint")
                .setAllowedOrigins("*")
                .addInterceptors(stompWebSocketInterceptor)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 访问处理器前缀
        registry.setApplicationDestinationPrefixes("/app");
        // 订阅允许的前缀（只有第一个前缀在 @MessageMapping 方法执行完毕后响应到代理时，如果没有加 @SendTo 或 @SendToUser 注解
        // 显示声明地址，会默认加上此处声明的第一个前缀，这里即 /topic
        registry.enableSimpleBroker("/topic", "/queue");
        // 点对点订阅前缀，配合订阅前缀即 /user/queue/其它
        registry.setUserDestinationPrefix("/user");
    }

    /**
     * 连接验证
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompChannelInterceptor);
    }

}
