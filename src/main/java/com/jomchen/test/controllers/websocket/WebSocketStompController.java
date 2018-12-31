package com.jomchen.test.controllers.websocket;

import com.jomchen.test.utils.RequestIdGenerator;
import com.jomchen.test.utils.RequestObject;
import com.jomchen.test.utils.ResultObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * create by Jomchen on 12/30/18
 */
@Controller
public class WebSocketStompController {

    @MessageMapping("/greeting")
    public ResultObject stompGreeting(@RequestBody RequestObject<String> requestObject) {
        System.out.println("这是 stomp 的内容：" + requestObject);
        System.out.println("这是 stomp 的内容：" + requestObject);
        System.out.println("这是 stomp 的内容：" + requestObject);
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                requestObject.getData()
        );
        return resultObject;
    }

    @SubscribeMapping("/once_once")
    public ResultObject subscribe() {
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                "我是初始化"
        );
        return resultObject;
    }


}
