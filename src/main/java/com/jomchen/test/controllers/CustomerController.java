package com.jomchen.test.controllers;

import com.jomchen.test.utils.UrlContents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by Jomchen on 2018/12/19
 */
@Controller
public class CustomerController {

    @RequestMapping(value = UrlContents.CUSTOMER_00)
    public String customer00() {
        return "customer/customer00";
    }

}
