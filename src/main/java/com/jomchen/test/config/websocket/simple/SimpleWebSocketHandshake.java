package com.jomchen.test.config.websocket.simple;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * create by Jomchen on 2018/12/28
 */
/*@Component
public class SimpleWebSocketHandshake extends DefaultHandshakeHandler {

    // DefaultHandshakeHandler
    // HandshakeHandler
    // 一般可以 验证源，谈判协议 等额外的功能

    private final String HEADERS_DEMO = "headers: %s<----------------->%s";
    private final String USER_DEMO = "username: --------------->>%s";

    @Override
    protected void handleInvalidConnectHeader(
            ServerHttpRequest request,
            ServerHttpResponse response) throws IOException {

        Principal principal = request.getPrincipal();
        if (null != principal) {
            String userName = principal.getName();
            String.format(USER_DEMO, userName);
        }
        HttpHeaders httpHeaders = request.getHeaders();
        if (null != httpHeaders && !httpHeaders.isEmpty()) {
            Set<Map.Entry<String, List<String>>> set =  httpHeaders.entrySet();
            for (Map.Entry<String, List<String>> m : set) {
                String key = m.getKey();
                List<String> valueList = m.getValue();
                for (int i = 0; i < valueList.size(); i ++) {
                    String printValue = String.format(HEADERS_DEMO, key, valueList.get(i));
                    logger.info(printValue);
                }
            }
        }

        logger.info("********************************************** processing simple websocket HANDSHAKE !!!");
        super.handleInvalidConnectHeader(request, response);
    }

}*/
