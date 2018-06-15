package com.coderme.mq;
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


    private String userName = "qdm";
    private String password = "123456";
    private String virtualHost = "/";
    private String hostName = "192.168.56.101";
    private int portNumber = 5672;

    private String exchangeName = "exchange1";
    private String routingKey = "exchange1";

    private String QUENUE_NAME = "quenueName1";


    @Test
    public void send() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        factory.setPort(portNumber);
        factory.setAutomaticRecoveryEnabled(true);
        factory.setNetworkRecoveryInterval(30000);
        Connection conn = null;
        Channel channel = null;
        try {

            conn = factory.newConnection();
            channel = conn.createChannel();
            channel.queueDeclare(QUENUE_NAME, false, false, false, null);

            byte[] messageBodyBytes = "Hello, world!".getBytes();
            channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.close();
            conn.close();
        }

    }

}
