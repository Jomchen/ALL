package com.lemonwind.test.config.rabbitmq.single;

import com.lemonwind.test.utils.RabbitmqMessage;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * create by lemonwind on 2018/12/24
 */
@Configuration
public class SingleConfig {

    @Autowired
    private Connection connection;

    /* -------------------------------------------------------
        单个消费端：
            声明：队列名（__未证实是交换器名）
            发送：空交换器，路由key（队列名）
    ------------------------------------------------------- */
    @Bean("singleChannel")
    public Channel singleChannel() throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclare(
                RabbitmqMessage.SINGLE_NAME,
                false,
                false,
                false,
                null
        );
        return channel;
    }

}
