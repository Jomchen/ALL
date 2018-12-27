package com.jomchen.test.config.rabbitmq.single;

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
public class SingleService {

    private Logger logger = LoggerFactory.getLogger(SingleService.class);

    @Autowired
    @Qualifier("singleChannel")
    private Channel singleChannel;

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        printDeclare("receive single");

        byte[] dataArray = delivery.getBody();
        String data = new String(dataArray, "UTF-8");
        logger.info(
                String.format(
                        RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO,
                        "receiveSingle",
                        data,
                        ""
                )
        );
    };

    @PostConstruct
    private void receiveSingle() {
        try {
            singleChannel.basicConsume(
                    RabbitmqMessage.SINGLE_NAME,
                    true,
                    deliverCallback,
                    consumerTag -> {}
            );
        } catch (IOException e) {
            logger.error(
                    String.format(
                            RabbitmqMessage.RECEIVE_ERROR_DEMO,
                            "receiveSingle",
                            e.getMessage(),
                            ""
                    ),
                    e
            );
            return;
        }
    }

    public void sendSingle(String data) throws UnsupportedEncodingException {
        byte[] sendData = data.getBytes("UTF-8");
        try {
            singleChannel.basicPublish(
                    "",
                    RabbitmqMessage.SINGLE_NAME,
                    null,
                    sendData);

            logger.info(
                    String.format(
                            RabbitmqMessage.SEND_SUCCESSFUL_DEMO,
                            "sendSingle",
                            data,
                            ""
                    )
            );
        } catch (IOException e) {
            logger.error(
                    String.format(
                            RabbitmqMessage.SEND_ERROR_DEMO,
                            "sendSingle",
                            data,
                            ""
                    ),
                    e
            );
            return;
        }
    }

    private void printDeclare(String data) {
        logger.info("\\\n \\\n  \\\n   \\\n    \\\n     \\\n      I am " + data);
    }
}
