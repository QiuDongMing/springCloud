package com.coderme.mq.service;

import com.coderme.BaseTest;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2018/6/14 15:48
 * @desc
 */
public class SenderServiceTest extends BaseTest {

    @Autowired
    private SenderService senderService;

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private RabbitMessagingTemplate template2;

    @Test
    public void send() throws Exception {
//        senderService.send(5);


        template.convertAndSend("quenue7", "my message");
        template2.convertAndSend("ex1","ex1", "tem2 message");

        Thread.sleep(3000L);
    }

}