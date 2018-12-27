package com.jomchen.test.config.rabbitmq.exchange;

import com.jomchen.test.utils.RabbitmqMessage;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * create by Jomchen on 2018/12/25
 */
@Service
public class FanoutService {

    private static Logger logger = LoggerFactory.getLogger(FanoutService.class);

    @Autowired
    @Qualifier("fanoutChannel")
    private Channel channel;

    public void sendFanout(String data) throws IOException {
        byte[] sendData = data.getBytes("UTF-8");
        channel.basicPublish(
                RabbitmqMessage.FANOUT_NAME,
                "",
                null,
                sendData
        );
        logger.info(
                String.format(
                        RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO,
                        "sendFanout",
                        data,
                        ""
                )
        );
    }

}
