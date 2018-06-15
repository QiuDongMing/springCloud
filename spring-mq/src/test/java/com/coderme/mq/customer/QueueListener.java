package com.coderme.mq.customer;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author qiudm
 * @date 2018/6/14 16:34
 * @desc
 */
@Component
public class QueueListener {

    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @RabbitListener(queues = "queue1")
    public void customer(Message message) {
        logger.error("message:{}", JSON.toJSONString(message));
    }

}
