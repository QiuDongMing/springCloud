package com.coderme.mq;

import com.coderme.BaseTest;
import com.coderme.mq.cofig.SenderConfig;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qiudm
 * @date 2018/6/27 15:44
 * @desc
 */
public class SendMessage extends BaseTest {

    @Autowired
    private AmqpTemplate template;

    @Test
    public void messageSend() throws Exception {
        template.convertAndSend(SenderConfig.MESSAGE_QUEUE,"message1");
        Thread.sleep(3000L);
    }



}
