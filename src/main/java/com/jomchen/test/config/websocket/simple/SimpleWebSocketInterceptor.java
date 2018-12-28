package com.jomchen.test.config.websocket.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * create by Jomchen on 12/27/18
 */
@Component
public class SimpleWebSocketInterceptor implements HandshakeInterceptor {

    private Logger logger = LoggerFactory.getLogger(SimpleWebSocketInterceptor.class);

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler,
            Map<String, Object> map) throws Exception {

        // 一般用于 阻止握手，传递一些可获取的参数到会话
        logger.info("---------------------------------------------- processing websocket handshake interceptor BERORE !!!");
        return true;
    }

    @Override
    public void afterHandshake(
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler,
            Exception e) {

        logger.info("---------------------------------------------- processing websocket handshake interceptor AFTER !!!");
    }

}
