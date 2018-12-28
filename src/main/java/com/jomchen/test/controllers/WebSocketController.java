package com.jomchen.test.controllers;

import com.jomchen.test.utils.UrlContents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by Jomchen on 2018/12/28
 */
@Controller
public class WebSocketController {

    @RequestMapping(value = UrlContents.WEBSOCKET_SIMPLE)
    public String simple() {
        return "websocket/simple";
    }

}
