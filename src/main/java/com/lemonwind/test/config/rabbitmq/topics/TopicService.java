package com.lemonwind.test.config.rabbitmq.topics;

import com.lemonwind.test.utils.RabbitmqMessage;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * create by lemonwind on 2018/12/26
 */
@Service
public class TopicService {

    private Logger logger = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    @Qualifier("topicChannel")
    private Channel channel;

    public void senTopics(String data, String routingKey) throws IOException {
        byte[] sendData = data.getBytes("UTF-8");
        channel.basicPublish(
                RabbitmqMessage.TOPICS_NAME,
                routingKey,
                null,
                sendData
        );

        logger.info(
                String.format(
                        RabbitmqMessage.SEND_SUCCESSFUL_DEMO,
                        "sendTopics",
                        data,
                        ""
                )
        );
    }


}
