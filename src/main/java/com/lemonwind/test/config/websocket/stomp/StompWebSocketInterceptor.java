package com.lemonwind.test.config.websocket.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * create by lemonwind on 12/30/18
 */
@Component("stompWebSocketInterceptor")
public class StompWebSocketInterceptor implements HandshakeInterceptor {

    private Logger logger = LoggerFactory.getLogger(StompWebSocketInterceptor.class);

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler,
            Map<String, Object> map) throws Exception {
        logger.info("--------------------------------------------> STOMP interceptor BEFORE");
        return true;
    }

    @Override
    public void afterHandshake(
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler,
            @Nullable Exception e) {
        logger.info("--------------------------------------------> STOMP interceptor AFTER");
    }
}
