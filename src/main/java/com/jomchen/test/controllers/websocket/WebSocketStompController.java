package com.jomchen.test.controllers.websocket;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.test.utils.RequestIdGenerator;
import com.jomchen.test.utils.ResultObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * create by Jomchen on 12/30/18
 */
@Controller
public class WebSocketStompController {

    /*@MessageMapping("/greeting")
    public String stompGreeting() {
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                null
        );
        return JSONObject.toJSONString(resultObject);
    }*/

}
