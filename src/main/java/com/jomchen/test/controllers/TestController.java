package com.jomchen.test.controllers;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.test.model.Test;
import com.jomchen.test.services.TestServiceImpl;
import com.jomchen.test.utils.UrlContents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * create by Jomchen on 2018/11/19
 */
@Controller
public class TestController {


    private Logger logger = LoggerFactory.getLogger(TestController.class);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Autowired
    private TestServiceImpl testService;


    /**
     *  所有的任何实验
     */
    @RequestMapping(value = UrlContents.MY_ALL_TEST)
    @ResponseBody
    public String myTest() {
        // 这里进行所有的任何实验
        // 这里进行所有的任何实验
        // 这里进行所有的任何实验

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("LINUX 00 -------------------> " + simpleDateFormat.format(new Date()));
        return new JSONObject()
                .fluentPut("code", 0)
                .fluentPut("msg", "successful")
                .toJSONString();
    }

    /**
     * 表单验证测试
     */
    @RequestMapping(value = UrlContents.FORM_TEST)
    public String formTest() {
        return "test/form_test";
    }




    @RequestMapping(value = UrlContents.TEST)
    @ResponseBody
    public String test() {
        List<Test> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Test t = new Test( "李寻欢" + i, 20 + i);
            list.add(t);
        }
        testService.handleBean(list.get(1));
        return "test";
    }

    @RequestMapping(value = UrlContents.TEST_00)
    @ResponseBody
    public String test1() {
        List<Test> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Test t = new Test( "李寻欢" + i, 20 + i);
            list.add(t);
        }
        testService.handleArray(list.toArray(new Test[list.size()]));
        return "test1";
    }

    @RequestMapping(value = UrlContents.TEST_01)
    @ResponseBody
    public String test2() {
        List<Test> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Test t = new Test( "李寻欢" + i, 20 + i);
            list.add(t);
        }
        testService.handleList(list);
        return "test2";
    }

}
