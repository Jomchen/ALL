package com.lemonwind.test.controllers.wechat;


import com.alibaba.fastjson.JSONObject;
import com.lemonwind.test.utils.UrlContents;
import com.lemonwind.test.utils.WechatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WechatController {

    private Logger logger = LoggerFactory.getLogger(WechatController.class);

    @Autowired
    private HttpServletRequest request;

    @Value("${lemonwind.wechat.appsecret}")
    private String appsecret;
    @Value("${lemonwind.wechat.appID}")
    private String appId;
    @Value("${lemonwind.wechat.token}")
    private String token;


    @RequestMapping(UrlContents.WECHAT_RECEIVE)
    @ResponseBody
    public String wechatReceive() {
        String signature = request.getParameter("signature");  // 签名
        String timestamp = request.getParameter("timestamp");  // 时间戳
        String nonce = request.getParameter("nonce");  // 随机字符串
        String echostr = request.getParameter("echostr");  // 随机数
        logger.warn("微信预成为开发者请求验证。。");
        boolean check = WechatUtils.checkSignature(signature, timestamp, nonce, token);
        logger.warn("微信成为开发者 " + (check ? "成功" : "失败"));

        return check ?
                echostr : new JSONObject()
                            .fluentPut("code", 0)
                            .fluentPut("msg", "success")
                            .toString();
    }

}
