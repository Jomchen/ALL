package com.jomchen.test.utils;


/**
 * create by Jomchen on 2018/12/24
 */
public interface RabbitmqMessage {

    String SEND_SUCCESSFUL_DEMO = "%s | SEND | %s >>>>>>>>>>>>> SUCCESSFUL     %s ____________________________ ";
    String SEND_ERROR_DEMO = "%s | SEND | %s !!!!!!!!!!!!>>>>>>> ERROR     %s ____________________________ ";

    String RECEIVE_SUCCESSFUL_DEMO = "____________________________ %s | SEND | %s ************* SUCCESSFUL     %s";
    String RECEIVE_ERROR_DEMO = "____________________________ %s | SEND | %s !!!!!!!!!!!!******* ERROR     %s";

    String SINGLE_NAME = "jomchen-queue-single";
    String MORE_SINGLE_NAME = "jomchen-queue-more-single";
    String FANOUT_NAME = "jomchen-fanout";
    String DIRECTORY_NAME = "jomchen-directory";
    String TOPICS_NAME = "jomchen-topics";

}
