package com.coderme.mq.cofig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiudm
 * @date 2018/6/27 15:41
 * @desc
 */
@Configuration
public class SenderConfig {

    public static final String MESSAGE_QUEUE = "MESSAGE";


    @Bean
    Queue messageQueue() {
        return new Queue(MESSAGE_QUEUE);
    }

}
