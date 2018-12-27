package com.jomchen.test.config.rabbitmq.moresingle;

import com.jomchen.test.utils.RabbitmqMessage;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * create by Jomchen on 2018/12/24
 */
@Configuration
public class MoreSingleConfig {

    @Autowired
    private Connection connection;

    /*---------------------------------------------------------------------------
        多个消费端竞争：
            声明：一个队列名（__未证实是交换器名）
            发送：空交换器，路由key（队列名）
    --------------------------------------------------------------------------- */
    @Bean("moreSingleChannel")
    public Channel moreSingleChannel() throws IOException {
        Channel channel = connection.createChannel();
        /* ---------------------------------
            注意：如果一个队列已经存在，如果再对同样名字的队列重新声明不同的参数，则会报错
            第一个参数是队列名
            第二个参数是信息是否持久化（如果这里声明队列是持久化，那么信息发送时也应该保证是持久化的）
        --------------------------------- */
        channel.queueDeclare(
                RabbitmqMessage.MORE_SINGLE_NAME,
                false,
                false,
                false,
                null
        );
        return channel;
    }

}
