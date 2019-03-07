package com.jomchen.test.controllers;

import com.jomchen.test.utils.UrlContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by Jomchen on 2018/12/17
 */
@Controller
public class IndexController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = UrlContents.INDEX)
    public String index() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            list.add(i + "JAVA");
        }
        request.setAttribute("myTime", new Date());
        request.setAttribute("list", list);
        request.setAttribute("username", "李寻欢");
        return "index";
    }

}
