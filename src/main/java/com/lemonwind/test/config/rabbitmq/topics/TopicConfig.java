package com.lemonwind.test.config.rabbitmq.topics;

import com.lemonwind.test.utils.RabbitmqMessage;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * create by lemonwind on 2018/12/26
 */
@Configuration
public class TopicConfig {

    private static Logger logger = LoggerFactory.getLogger(TopicConfig.class);

    @Autowired
    private Connection connection;

    @Bean("topicChannel")
    public Channel topicChannel() throws IOException {
        // 如果要实验这种交换器则需要在不同的服务器上配不同的 routingKey
        String routingKey = "*.lemonwind.*";
        Channel channel = connection.createChannel();

        String queueId = channel.queueDeclare().getQueue();
        channel.exchangeDeclare(RabbitmqMessage.TOPICS_NAME, BuiltinExchangeType.TOPIC);
        channel.queueBind(queueId, RabbitmqMessage.TOPICS_NAME, routingKey);
        channel.basicConsume(queueId, true, (String consumerTag, Delivery message) -> {
            printDeclare("receiveTopics");
            byte[] data = message.getBody();
            String receiveData = new String(data, "UTF-8");
            logger.info(String.format(RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO, "receiveTopics", receiveData, ""));
        }, consumerTag -> {});

        return channel;
    }


    private static void printDeclare(String data) {
        logger.info("\\\n \\\n  \\\n   \\\n    \\\n     \\\n      I am " + data);
    }
}
