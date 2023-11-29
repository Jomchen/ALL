package com.lemonwind.test.utils;


/**
 * create by lemonwind on 2018/12/24
 */
public interface RabbitmqMessage {

    String SEND_SUCCESSFUL_DEMO = "%s | SEND | %s >>>>>>>>>>>>> SUCCESSFUL     %s ____________________________ ";
    String SEND_ERROR_DEMO = "%s | SEND | %s !!!!!!!!!!!!>>>>>>> ERROR     %s ____________________________ ";

    String RECEIVE_SUCCESSFUL_DEMO = "____________________________ %s | SEND | %s ************* SUCCESSFUL     %s";
    String RECEIVE_ERROR_DEMO = "____________________________ %s | SEND | %s !!!!!!!!!!!!******* ERROR     %s";

    String SINGLE_NAME = "lemonwind-queue-single";
    String MORE_SINGLE_NAME = "lemonwind-queue-more-single";
    String FANOUT_NAME = "lemonwind-fanout";
    String DIRECTORY_NAME = "lemonwind-directory";
    String TOPICS_NAME = "lemonwind-topics";

}
