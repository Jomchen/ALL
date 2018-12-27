package com.jomchen.test.config.rabbitmq.moresingle;

import com.jomchen.test.utils.RabbitmqMessage;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * create by Jomchen on 2018/12/24
 */
@Service
public class MoreSingleService {

    private Logger logger = LoggerFactory.getLogger(MoreSingleService.class);

    @Autowired
    @Qualifier("moreSingleChannel")
    private Channel moreSingleChannel;

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        printDeclare("receive moreSingle");
        byte[] dataArray = delivery.getBody();
        String data = new String(dataArray, "UTF-8");
        logger.info(
                String.format(
                        RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO,
                        "receiveMoreSingle",
                        data,
                        "START"
                )
        );
        if (data.contains(".")) {
            for (char i : data.toCharArray()) {
                if (i == '.') {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        logger.error("Thread sleep error !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", e);
                    }
                }
            }
        }
        logger.info(
                String.format(
                        RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO,
                        "receiveMoreSingle",
                        data,
                        "END"
                )
        );

        // 这里是手动告知 rabbitmq 已经处理了，后一个参数是是否一次承认全部，应该成 false 合理
        moreSingleChannel.basicAck(
                delivery.getEnvelope().getDeliveryTag(),
                false
        );
    };

    @PostConstruct
    private void receiveMoreSingle() throws IOException {
        moreSingleChannel.basicQos(1);

        // 在接收的同时不自动确认，在处理完 逻辑时手动确认
        boolean autoAck = false;
        try {
            moreSingleChannel.basicConsume(
                    RabbitmqMessage.MORE_SINGLE_NAME,
                    autoAck,
                    deliverCallback,
                    consumerTag -> {}
            );
        } catch (IOException e) {
            logger.error(
                    String.format(
                            RabbitmqMessage.RECEIVE_ERROR_DEMO,
                            "receiveMoreSingle",
                            e.getMessage(),
                            ""
                    ),
                    e
            );
        }
    }

    public void sendMoreSingle(String data) throws UnsupportedEncodingException {
        byte[] sendArray = data.getBytes("UTF-8");
        try {
            /* ---------------------------------
            第一个参数是 交换器
            第二个参数是信息是队列名
            第三个参数是信息上传属性，在此可以声明信息持久化，但是要保证 这里 和 队列声明都持久化才行
            第四个参数是上传数据
        --------------------------------- */
            moreSingleChannel.basicPublish(
                    "",
                    RabbitmqMessage.MORE_SINGLE_NAME,
                    null,
                    sendArray
            );

            logger.info(
                    String.format(
                            RabbitmqMessage.SEND_SUCCESSFUL_DEMO,
                            "sendMoreSingle",
                            data,
                            ""
                    )
            );
        } catch (IOException e) {
            logger.error(
                    String.format(
                            RabbitmqMessage.SEND_ERROR_DEMO,
                            "sendMoreSingle",
                            data,
                            ""
                    ),
                    e
            );
        }
    }

    private void printDeclare(String data) {
        logger.info("\\\n \\\n  \\\n   \\\n    \\\n     \\\n      I am " + data);
    }
}
