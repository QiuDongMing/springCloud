package com.coderme.mq.service;

import com.coderme.BaseTest;
import org.junit.Test;
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

    @Test
    public void send() throws Exception {
        senderService.send(5);
        Thread.sleep(3000L);
    }

}