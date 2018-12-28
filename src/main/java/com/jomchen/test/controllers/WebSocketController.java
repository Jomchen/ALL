package com.jomchen.test.controllers;

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
     * @return
     */
    @RequestMapping(value = UrlContents.WEBSOCKET_SIMPLE)
    public String simple() {
        return "websocket/websocket_page";
    }

    /**
     * sockjs 运用
     */
    @RequestMapping(value = UrlContents.SOCKJS_PAGE)
    public String sockjsPage() {
        return "websocket/sockjs_page";
    }

}
