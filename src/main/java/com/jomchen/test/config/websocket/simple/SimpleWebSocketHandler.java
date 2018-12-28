package com.jomchen.test.config.websocket.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * create by Jomchen on 12/27/18
 */
@Component
public class SimpleWebSocketHandler extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(SimpleWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("---------------------------------------------- simple websocket set up connection");
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(
            WebSocketSession session,
            TextMessage message) throws Exception {
        String data = message.getPayload();
        logger.info("---------------------------------------------- simple websocket receive message: " + data);
        session.sendMessage(message);
    }

    @Override
    public void handleTransportError(
            WebSocketSession session,
            Throwable exception) throws Exception {
        logger.info("---------------------------------------------- simple websocket transport error");
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session,
            CloseStatus status) throws Exception {
        logger.info("---------------------------------------------- simple websocket close");
        super.afterConnectionClosed(session, status);
    }

    @Override
    public boolean supportsPartialMessages() {
        logger.info("---------------------------------------------- simple websocket if split piece ?");
        return super.supportsPartialMessages();
    }

}
