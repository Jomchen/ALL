package com.lemonwind.test.controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * create by lemonwind on 2018/12/24
 */
@Controller
public class GenerateTemplateController {



    /**
     * 生成模板内容
     */
    private static void generateTemplate(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File("/"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        Map root = new HashMap();
        root.put("username", "李寻欢");
        root.put("age", "40");

        Template temp = cfg.getTemplate("lemonwindTemplate.ftl");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("/lemonwindTemplate.txt"));
        Writer out = new OutputStreamWriter(fileOutputStream);
        temp.process(root, out);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
