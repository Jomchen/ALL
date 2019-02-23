package com.jomchen.test.controllers;

import com.jomchen.test.model.User;
import com.jomchen.test.services.UserServiceImpl;
import com.jomchen.test.utils.UrlContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(UrlContents.USER_TEST)
    @ResponseBody
    public User queryById(String id) {
        return userService.queryById(id);
    }

}
