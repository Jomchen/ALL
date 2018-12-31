package com.jomchen.test.config.websocket.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by Jomchen on 12/31/18
 */
@Component("stompChannelInterceptor")
public class StompChannelInterceptor implements ChannelInterceptor {

    Map<String, JomchenAuthentication> AUTHENTICATION = new ConcurrentHashMap<>();

    private Logger logger = LoggerFactory.getLogger(StompChannelInterceptor.class);

    @Nullable
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        MessageHeaders messageHeaders = message.getHeaders();
        StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor
                .getAccessor(message, StompHeaderAccessor.class);
        if (null != messageHeaders) {
            logger.info("****************** headers START");
            for (Map.Entry<String,Object> entry : messageHeaders.entrySet()) {
                logger.info(entry.getKey() + "<********************>" + entry.getValue());
            }
            logger.info("****************** headers END");
        }

        if (StompCommand.CONNECT.equals(stompHeaderAccessor.getCommand())) {
            logger.info("-------------> Stomp 首次连接");
            String username = stompHeaderAccessor.getNativeHeader("username").get(0);
            String passowrd = stompHeaderAccessor.getNativeHeader("password").get(0);
            JomchenAuthentication jomchenAuthentication = new JomchenAuthentication(username);
            AUTHENTICATION.put(username, jomchenAuthentication);
            stompHeaderAccessor.setUser(jomchenAuthentication);
            return message;
        } else {
            logger.info("-------------> Stomp 非首次连接");
            return message;
        }
    }

}
