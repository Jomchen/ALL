package com.lemonwind.test.config.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * create by lemonwind on 2018/12/24
 */
@Configuration
public class RabbitmqConfig {

    @Value("${customer.rabbitmq.host}")
    private String host;
    @Value("${customer.rabbitmq.port}")
    private int port;
    @Value("${customer.rabbitmq.username}")
    private String username;
    @Value("${customer.rabbitmq.password}")
    private String password;
    @Value("${customer.rabbitmq.virtualHost}")
    private String virtualHost;


    @Bean
    public Connection rabbitmqConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(host);
            connectionFactory.setPort(port);
            connectionFactory.setUsername(username);
            connectionFactory.setPassword(password);
            connectionFactory.setVirtualHost(virtualHost);

        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
