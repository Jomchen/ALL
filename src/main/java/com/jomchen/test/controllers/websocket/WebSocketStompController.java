package com.jomchen.test.controllers.websocket;

import com.jomchen.test.utils.RequestIdGenerator;
import com.jomchen.test.utils.RequestObject;
import com.jomchen.test.utils.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * create by Jomchen on 12/30/18
 */
@Controller
public class WebSocketStompController {

    private Logger logger = LoggerFactory.getLogger(WebSocketStompController.class);

    @MessageMapping("/greeting") // /app/greenting 可以请求到
    public ResultObject stompGreeting(@RequestBody RequestObject<String> requestObject) {
        logger.info("This is content of Stomp =>" + requestObject);
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                requestObject.getData()
        );
        return resultObject;
    }

    @SubscribeMapping("/once_once") // /app/once_once 可以一次性订阅到
    public ResultObject subscribe() {
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                "我是初始化"
        );
        return resultObject;
    }

    @MessageExceptionHandler
    public ResultObject handleError(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        ResultObject<String> result = ResultObject.buildFail(
                RequestIdGenerator.generate(),
                throwable.getMessage()
        );
        return result;
    }

}
