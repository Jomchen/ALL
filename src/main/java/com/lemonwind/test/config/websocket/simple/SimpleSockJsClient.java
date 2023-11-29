package com.lemonwind.test.config.websocket.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

/**
 * create by lemonwind on 12/30/18
 */
/*@Configuration
public class SimpleSockJsClient {

    @Autowired
    private SimpleWebSocketHandler2 simpleWebSocketHandler2;

    @PostConstruct
    public void execute() {
        List<Transport> transports = new LinkedList<>();
        StandardWebSocketClient standardWebSocketClient = new StandardWebSocketClient();
        WebSocketTransport webSocketTransport = new WebSocketTransport(standardWebSocketClient);
        RestTemplateXhrTransport templateXhrTransport = new RestTemplateXhrTransport();
        transports.add(webSocketTransport);
        transports.add(templateXhrTransport);

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.doHandshake(simpleWebSocketHandler2, "ws://192.168.0.103:8080/simpleWebSocket");
    }
}*/
