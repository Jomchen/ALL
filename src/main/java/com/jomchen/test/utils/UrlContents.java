package com.jomchen.test.utils;

/**
 * create by Jomchen on 2018/11/21
 */
public interface UrlContents {

    String INDEX = "/";                                    // 主页

    String DOWN_LOAD = "/test/download";                   // 下载测试
    String TEST_GENERATE_CSV = "/test/generate/csv";       // 测试生成 csv
    String TEST_RESOLVE_CSV = "/test/resolve/csv";         // 测试解析 csv
    String TEST_UPLOAD_PAGE = "/test/upload/page";         // 上传文件测试页面
    String TEST_UPLOAD_FILE = "/test/upload/file";         // 上传文件

    String WECHAT_RECEIVE = "/jomchen/wechat/receive";     // 成为 wechat 开发者

    String RABBITMQ_SINGLE = "/rabbitmq/single";
    String RABBITMQ_MORE_SINGLE = "/rabbitmq/more/single";
    String RABBITMQ_FANOUT= "/rabbitmq/fanout";
    String RABBITMQ_DIRECTORY= "/rabbitmq/directory";
    String RABBITMQ_TOPICS = "/rabbitmq/topics";

    String MY_ALL_TEST = "/my/all/test";
    String FORM_TEST = "/form/test";
    String TEST = "/test";
    String TEST_00 = "/test00";
    String TEST_01 = "/test01";

    String USER_TEST = "/user/test";

    String WEBSOCKET_SIMPLE = "/websocket/simple/page";
    String SOCKJS_PAGE = "/websocket/sockjs/page";
    String STOMP_PAGE = "/websocket/stomp/page";

}
