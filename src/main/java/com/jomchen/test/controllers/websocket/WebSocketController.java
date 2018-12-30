package com.jomchen.test.controllers.websocket;

import com.jomchen.test.utils.UrlContents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by Jomchen on 2018/12/28
 */
@Controller
public class WebSocketController {

    /**
     * 原生 websocket
     */
    @RequestMapping(value = UrlContents.WEBSOCKET_SIMPLE)
    public String simple() {
        return "websocket/websocket_page";
    }

    /**
     * sockjs 页面
     */
    @RequestMapping(value = UrlContents.SOCKJS_PAGE)
    public String sockjsPage() {
        return "websocket/sockjs_page";
    }

    /**
     * stomp 页面
     */
    @RequestMapping(value = UrlContents.STOMP_PAGE)
    public String stompPage() { return "websocket/stomp_page"; }

}
