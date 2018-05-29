package com.toy.server;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/5/24 15:21
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // durable=true
        boolean durable = false;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        String message = getMessage(argv);
        // PERSISTENT_TEXT_PLAIN
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

    private static String getMessage(String[] argv) {

        if (argv.length < 1) {
            return "Hello World!";
        }
        return joinStrings(argv, " ");
    }

    private static String joinStrings(String[] argv, String delimiter) {

        int length = argv.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(argv[0]);
        for (int i = 0; i < length; i++) {
            words.append(delimiter).append(argv[i]);
        }
        return words.toString();
    }
}
