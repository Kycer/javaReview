package com.study.amqp2;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author yk
 * @version 1.0 Date: 2017/8/2
 */
public class Producer extends CPMBase {
    public Producer(String queueName) throws IOException {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("", queueName, null, SerializationUtils.serialize(object));
    }
}
