package com.toy.server;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Gaohaiqing
 * @Date: 2018/5/24 15:21
 */
public class Send {

    private final static String QUEUE_NAME = "rpc_queue";
    private String replyQueueName;
    private final static String EXCHANGE_NAME = "logs";
    Channel channel;
    Connection connection;

    public Send() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();

        replyQueueName = channel.queueDeclare().getQueue();
    }

    public String call(String message) throws IOException, TimeoutException, InterruptedException {

        String corrId = UUID.randomUUID().toString();
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", QUEUE_NAME, props, message.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (properties.getCorrelationId().equals(corrId)) {
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });

        return response.take();
    }

    public void close() throws IOException {
        connection.close();
    }

    public static void main(String[] args) throws InterruptedException, TimeoutException, IOException {
        Send send = new Send();
        String call = send.call("client send message");
        System.out.println("get response:" + call);
        send.close();
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
