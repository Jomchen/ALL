package com.lemonwind.test.config.websocket.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * create by lemonwind on 12/30/18
 */
@Component("simpleWebSocketHandler2")
public class SimpleWebSocketHandler2 extends TextWebSocketHandler {

    Logger logger = LoggerFactory.getLogger(SimpleWebSocketHandler2.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        byte[] dataArray = message.asBytes();
        String data2 = new String(dataArray, "UTF-8");
        String data = message.getPayload();
        logger.info("*******************>" + data);
        logger.info("*******************>>" + data2);
    }

}
