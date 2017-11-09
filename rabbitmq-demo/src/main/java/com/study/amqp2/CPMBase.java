package com.study.amqp2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yk
 * @version 1.0 Date: 2017/8/2
 */
public abstract class CPMBase {

    private final String HOST_NAME = "192.168.1.11";
    private final Integer PORT = 5672;
    private final String USER_NAME = "admin";
    private final String PASSWORD = "admin";

    protected Channel channel;
    protected Connection connection;
    protected  String queueName;

    public CPMBase(String queueName) throws IOException {
        this.queueName = queueName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        try {
            connection = factory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
            connection = null;
        }
        channel = connection.createChannel();
        channel.queueDeclare(this.queueName, false, false, false, null);
    }

    public void close() throws IOException{
        try{
            this.channel.close();
        } catch (TimeoutException e){
            e.printStackTrace();
        }
        this.connection.close();
    }

}
