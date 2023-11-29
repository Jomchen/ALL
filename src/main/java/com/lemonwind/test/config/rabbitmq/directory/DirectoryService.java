package com.lemonwind.test.config.rabbitmq.directory;

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
public class DirectoryService {

    private static Logger logger = LoggerFactory.getLogger(DirectoryService.class);

    @Autowired
    @Qualifier("directoryChannel")
    private Channel channel;


    public void sendDirectory(String data, String routeKey) throws IOException {
        byte[] sendData = data.getBytes("UTF-8");
        channel.basicPublish(
                RabbitmqMessage.DIRECTORY_NAME,
                routeKey,
                null,
                sendData
        );

        logger.info(
                String.format(
                        RabbitmqMessage.RECEIVE_SUCCESSFUL_DEMO,
                        "sendDirectory",
                        data,
                        ""
                )
        );
    }

    private static void printDeclare(String data) {
        logger.info("\\\n \\\n  \\\n   \\\n    \\\n     \\\n      I am " + data);
    }
}
