package com.jomchen.test.controllers.websocket;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.test.utils.RequestIdGenerator;
import com.jomchen.test.utils.ResultObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * create by Jomchen on 12/30/18
 */
@Controller
public class WebSocketStompController {

    @MessageMapping("/greeting")
    public String stompGreeting(@RequestBody String body) {
        System.out.println("这是 stomp 的内容：" + body);
        System.out.println("这是 stomp 的内容：" + body);
        System.out.println("这是 stomp 的内容：" + body);
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                null
        );
        return JSONObject.toJSONString(resultObject);
    }

}
