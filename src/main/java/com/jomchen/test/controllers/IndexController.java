package com.jomchen.test.controllers;

import com.jomchen.test.utils.UrlContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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

    @Autowired
    private HttpServletResponse response;

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

    @RequestMapping(value = "/download")
    public void download() throws IOException {
        FileSystemResource fileSystemSource = new FileSystemResource("/opt/ngrok.config.tar.gz");
        String fileName = fileSystemSource.getFilename();
        InputStream inputStream = fileSystemSource.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int i;
        while ( (i = inputStream.read(bytes)) != -1 ) {
            byteArrayOutputStream.write(bytes, 0, i);
        }
        inputStream.close();


        // 配置文件下载
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        byte[] data = byteArrayOutputStream.toByteArray();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
    }

}
