package com.lemonwind.test.config.rabbitmq.exchange;

import com.lemonwind.test.utils.RabbitmqMessage;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * create by lemonwind on 2018/12/25
 */
@Configuration
public class FanoutConfig {

    private static Logger logger = LoggerFactory.getLogger(FanoutConfig.class);

    @Autowired
    private Connection connection;

    /* ----------------------------------
        发送：交换器，空路由key
    ---------------------------------- */
    @Bean("fanoutChannel")
    public Channel fanoutChannel() throws IOException {
        Channel channel = connection.createChannel();

        /* -------------
            声明 匿名队列
            声明 fanout 交换器
            绑定 队列 和 交换器 到一个 空的路由key
        ------------- */
        /*String queueId = channel.queueDeclare().getQueue();*/

        String queueId  = channel.queueDeclare(
                "queue-fanout-" + System.currentTimeMillis(),
                false,
                false,
                true,
                null
        ).getQueue();
        channel.exchangeDeclare(
                RabbitmqMessage.FANOUT_NAME,
                BuiltinExchangeType.FANOUT
        );
        channel.queueBind(
                queueId,
                RabbitmqMessage.FANOUT_NAME,
                ""
        );

        // 消费端
        channel.basicConsume(queueId, true, (String consumerTag, Delivery message) -> {
            printDeclare("recive fanout");
            byte[] data = message.getBody();
            String receiveData = new String(data, "UTF-8");
            logger.info(String.format(RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO, "recieveFanout", receiveData, ""));
        }, consumerTag -> {});

        return channel;
    }

    private static void printDeclare(String data) {
        logger.info("\\\n \\\n  \\\n   \\\n    \\\n     \\\n      I am " + data);
    }

}
