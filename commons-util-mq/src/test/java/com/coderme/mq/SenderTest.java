package com.coderme.mq;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

/**
 * @author qiudm
 * @date 2018/6/1 16:45
 * @desc
 */
public class SenderTest {


    private String userName = "";
    private String password = "";
    private String virtualHost = "";
    private String hostName = "";
    private int portNumber = 0;

    private String exchangeName = "";
    private String routingKey = "";


    @Test
    public void send() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        factory.setPort(portNumber);
        Connection conn = null;
        Channel channel = null;
        try {
            conn = factory.newConnection();
            channel = conn.createChannel();

            channel.exchangeDeclare(exchangeName, "direct", true);
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, exchangeName, routingKey);
            Byte[] b = new Byte[125];

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.close();
            conn.close();
        }

    }

}
