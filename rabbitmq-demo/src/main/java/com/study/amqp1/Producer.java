package com.study.amqp1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * 消息提供者
 * @author yk
 * @version 1.0 Date: 2017/8/2
 */
public class Producer {
    private final static String QUEUE_NAME="rabbitMQ.test";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("192.168.1.11");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i=0; i< 100; i++){
            String message = "Hello RabbitMQ "+i;
            //发送消息到队列中
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("发送消息：" + message);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
