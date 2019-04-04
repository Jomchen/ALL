package com.jomchen.test.controllers;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.jomchen.test.model.Test;
import com.jomchen.test.services.TestServiceImpl;
import com.jomchen.test.utils.ResultObject;
import com.jomchen.test.utils.UrlContents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * create by Jomchen on 2018/11/19
 */
@Controller
public class TestController {

    @Autowired
    private TestServiceImpl testService;
    @Autowired
    private HttpServletResponse response;

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

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


    /**
     * 测试下载
     */
    @RequestMapping(value = UrlContents.DOWN_LOAD)
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

    /**
     * 读取 csv 文件
     */
    @RequestMapping(value = UrlContents.TEST_RESOLVE_CSV)
    @ResponseBody
    public ResultObject testGenerateCsv() throws IOException {
        List<String[]> list = new LinkedList<>();
        FileInputStream fileInputStream = new FileInputStream("/opt/test.csv");
        CsvReader csvReader = new CsvReader(fileInputStream, ',', Charset.forName("UTF-8"));
        csvReader.readHeaders();
        while(csvReader.readRecord()) {
            String[] data = csvReader.getValues();
            list.add(data);
        }
        csvReader.close();

        list.stream().map(Arrays::toString).map(e -> "体信息--------->"+e).forEach(System.out::println);
        return ResultObject.buildSuccess("readCsv");
    }

    /**
     * 生成 csv 文件
     */
    @RequestMapping(value = UrlContents.TEST_GENERATE_CSV)
    @ResponseBody
    public ResultObject testresolveCsv() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/opt/test.csv");
        CsvWriter csvWriter = new CsvWriter(fileOutputStream, ',', Charset.forName("UTF-8"));
        String[] title = {"姓名", "年龄", "地址"};
        csvWriter.writeRecord(title);
        for (int i = 0; i < 3; i ++) {
            String[] data = {"李寻欢" + i, String.valueOf(20 + i), "京城" + i};
            csvWriter.writeRecord(data);
        }
        csvWriter.writeRecord(new String[] {"kk", "kk"});

        csvWriter.flush();
        csvWriter.close();
        return ResultObject.buildSuccess("writeCsv");
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
