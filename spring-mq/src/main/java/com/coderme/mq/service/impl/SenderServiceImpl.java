package com.coderme.mq.service.impl;

import com.coderme.mq.service.SenderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiudm
 * @date 2018/6/14 15:34
 * @desc
 */
@Service
public class SenderServiceImpl implements SenderService {

    @Autowired
    private AmqpTemplate template;

    @Override
    public void send(int count) {
        for (int i=0; i <count;i++) {
            String msg = "msg" + i;
            template.convertAndSend("queuexx", msg);
        }

    }

}
