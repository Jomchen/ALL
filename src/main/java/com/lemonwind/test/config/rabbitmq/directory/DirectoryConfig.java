package com.lemonwind.test.config.rabbitmq.directory;

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
public class DirectoryConfig {

    static Logger logger = LoggerFactory.getLogger(DirectoryConfig.class);

    @Autowired
    private Connection connection;

    @Bean("directoryChannel")
    public Channel directoryChannel() throws IOException {
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(
                RabbitmqMessage.DIRECTORY_NAME,
                BuiltinExchangeType.DIRECT
        );

        /*String queueId = channel.queueDeclare().getQueue();*/
        String queueId = channel.queueDeclare(
                "queue-directory-" + System.currentTimeMillis(),
                false,
                false,
                true,
                null
        ).getQueue();

        // 为了实现不同的信息路由到不同的地方，这里绑定的 路由key 应该改动
        channel.queueBind(
                queueId,
                RabbitmqMessage.DIRECTORY_NAME,
                "info"
        );

        channel.basicConsume(queueId, true, (String consumerTag, Delivery message) -> {
            printDeclare("recive directory");
            byte[] data = message.getBody();
            String receiveData = new String(data, "UTF-8");
            logger.info(String.format(RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO, "receiveDirectory", receiveData, ""));
        }, consumerTag -> {});


        return channel;
    }

    private static void printDeclare(String data) {
        logger.info("\\\n \\\n  \\\n   \\\n    \\\n     \\\n      I am " + data);
    }

}
