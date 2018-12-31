package com.jomchen.test.controllers.websocket;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.test.utils.RequestIdGenerator;
import com.jomchen.test.utils.RequestObject;
import com.jomchen.test.utils.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * create by Jomchen on 12/30/18
 */
@Controller
public class WebSocketStompController {

    private Logger logger = LoggerFactory.getLogger(WebSocketStompController.class);

    @Autowired
    @Qualifier("brokerMessagingTemplate")
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 广播信息
     * /app/greenting 可以请求到这里
     * 订阅 /topic/greeting
     */
    @MessageMapping("/greeting")
    public ResultObject stompGreeting(@RequestBody RequestObject<String> requestObject) {
        logger.info("This is content of Stomp =>" + requestObject);
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                requestObject.getData()
        );
        return resultObject;
    }

    /**
     * 这里是发给了自己
     * /app/stompToUser 可以请求到这里
     * 订阅 /user/queue/sendToMySelf 可以接到指定发送
     */
    @MessageMapping("/sendToMySelf")
    @SendToUser("/queue/sendToMySelf")
    public ResultObject sendToMySelf(@RequestBody RequestObject<String> requestObject) {
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                requestObject.getData()
        );

        return resultObject;
    }

    /**
     * 发给指定用户
     * /app/sendToUser 可以请求到这里
     * 订阅 /user/queue/stompToUser 相应用户可以接收到这里反馈的信息
     */
    @MessageMapping("/sendToUser")
    public void sendToUser(@RequestBody RequestObject<String> requestObject) {
        String jsonStr = requestObject.getData();
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String sendUser = jsonObject.getString("sendUser");
        String sendData = jsonObject.getString("sendData");
        simpMessagingTemplate.convertAndSendToUser(sendUser, "/queue/sendToUser", sendData);
    }

    /**
     * 一次性订阅
     * 订阅 /app//once_once 可以一次性得到信息，这里相当于在初始化
     */
    @SubscribeMapping("/once_once") // /app/once_once 可以一次性订阅到
    public ResultObject subscribe() {
        ResultObject<String> resultObject = ResultObject.buildSuccess(
                RequestIdGenerator.generate(),
                "我是初始化"
        );
        return resultObject;
    }

    /**
     * 处理错误
     */
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