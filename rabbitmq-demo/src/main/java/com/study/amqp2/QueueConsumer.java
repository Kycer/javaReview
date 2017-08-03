package com.study.amqp2;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yk
 * @version 1.0 Date: 2017/8/2
 */
public class QueueConsumer extends CPMBase implements Runnable, Consumer {

    public QueueConsumer(String queueName) throws IOException {
        super(queueName);
    }

    @Override
    public void run() {
        try {
            channel.basicConsume(queueName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleConsumeOk(String s) {
        System.out.println("消费者接受到: " + s);
    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(bytes);
        map.forEach((k, v)->{
            System.out.println("消息" + v + " 消费成功");
        });
    }

    @Override
    public void handleCancelOk(String s) {
    }

    @Override
    public void handleCancel(String s) throws IOException {
    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {
    }

    @Override
    public void handleRecoverOk(String s) {
    }
}
