package com.lemonwind.test.config.websocket.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by lemonwind on 12/27/18
 */
@Component("simpleWebSocketHandler")
public class SimpleWebSocketHandler extends TextWebSocketHandler {

    private static ConcurrentHashMap<String, WebSocketSession> SESSION_SET = new ConcurrentHashMap<>();

    private Logger logger = LoggerFactory.getLogger(SimpleWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("---------------------------------------------- simple websocket set up connection");
        SimpleWebSocketHandler.SESSION_SET.put(session.getId(), session);
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(
            WebSocketSession session,
            TextMessage message) throws Exception {

        String data = message.getPayload();
        for (Map.Entry<String, WebSocketSession> s : SimpleWebSocketHandler.SESSION_SET.entrySet()) {
            s.getValue().sendMessage(message);
        }
        logger.info("---------------------------------------------- simple websocket receive message: " + data);
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
        SimpleWebSocketHandler.SESSION_SET.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    @Override
    public boolean supportsPartialMessages() {
        logger.info("---------------------------------------------- simple websocket if split piece ?");
        return super.supportsPartialMessages();
    }

}
