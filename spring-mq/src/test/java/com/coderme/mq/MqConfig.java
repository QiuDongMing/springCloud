package com.coderme.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiudm
 * @date 2018/6/14 15:57
 * @desc
 */
@Configuration
public class MqConfig {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(MqConfig.class);

    @Bean
    Queue queue1(){
        Queue queue = new Queue("queue1");
        logger.debug("队列1实例化完成");
        return queue;
    }


    @Bean
    Queue queue2(){
        Queue queue = new Queue("queue2");
        logger.debug("队列2实例化完成");
        return queue;
    }

    @Bean
    Queue queue3(){
        Queue queue = new Queue("queue3");
        logger.debug("队列3实例化完成");
        return queue;
    }






}
