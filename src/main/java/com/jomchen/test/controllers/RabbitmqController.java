package com.jomchen.test.controllers;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.test.config.rabbitmq.directory.DirectoryService;
import com.jomchen.test.config.rabbitmq.exchange.FanoutService;
import com.jomchen.test.config.rabbitmq.moresingle.MoreSingleService;
import com.jomchen.test.config.rabbitmq.single.SingleService;
import com.jomchen.test.config.rabbitmq.topics.TopicService;
import com.jomchen.test.utils.UrlContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * create by Jomchen on 2018/12/24
 */
@Controller
public class RabbitmqController {

    @Autowired
    private SingleService singleService;
    @Autowired
    private MoreSingleService moreSingleService;
    @Autowired
    private FanoutService fanoutService;
    @Autowired
    private DirectoryService directoryService;
    @Autowired
    private TopicService topicService;

    /**
     * 测试单个队列
     */
    @RequestMapping(UrlContents.RABBITMQ_SINGLE)
    @ResponseBody
    public String sendSingle(String data) throws UnsupportedEncodingException {
        singleService.sendSingle(data);
        return new JSONObject()
                .fluentPut("code", 0)
                .fluentPut("msg", "successful")
                .toJSONString();
    }

    /**
     * 测试多时个客户端竞争单个队列
     */
    @RequestMapping(UrlContents.RABBITMQ_MORE_SINGLE)
    @ResponseBody
    public String sendMoreSingle(int count, String data) throws UnsupportedEncodingException {
        for (int i = 0; i < count; i ++) {
            StringBuffer s = new StringBuffer();
            s.append(data).append(i).append("..");
            moreSingleService.sendMoreSingle(s.toString());
        }
        return new JSONObject()
                .fluentPut("code", 0)
                .fluentPut("msg", "successful")
                .toJSONString();
    }

    /**
     * 测试广播
     */
    @RequestMapping(UrlContents.RABBITMQ_FANOUT)
    @ResponseBody
    public String sendMoreSingle(String data) throws IOException {
        fanoutService.sendFanout(data);
        return new JSONObject()
                .fluentPut("code", 0)
                .fluentPut("msg", "successful")
                .toJSONString();
    }

    /**
     * 测试定向 路由key
     */
    @RequestMapping(UrlContents.RABBITMQ_DIRECTORY)
    @ResponseBody
    public String sendDirectory(String data, String routingKey) throws IOException {
        directoryService.sendDirectory(data, routingKey);
        return new JSONObject()
                .fluentPut("code", 0)
                .fluentPut("msg", "successful")
                .toJSONString();
    }

    /**
     * 测试主题选择 路由key
     */
    @RequestMapping(UrlContents.RABBITMQ_TOPICS)
    @ResponseBody
    public String senTopics(String data, String routingKey) throws IOException {
        topicService.senTopics(data, routingKey);
        return new JSONObject()
                .fluentPut("code", 0)
                .fluentPut("msg", "successful")
                .toJSONString();
    }

}
