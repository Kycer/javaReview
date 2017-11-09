package com.study.amqp2;

import java.util.HashMap;

/**
 * @author yk
 * @version 1.0 Date: 2017/8/2
 */
public class Main {
    public Main() throws Exception{

        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue");

        for (int i = 0; i < 5; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("消息 "+ i +" 发送成功");
        }
    }

    public static void main(String[] args) throws Exception{
        new Main();
        System.out.println("##############end...");
    }
}
