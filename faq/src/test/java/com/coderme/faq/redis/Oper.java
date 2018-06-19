package com.coderme.faq.redis;

import com.coderme.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author qiudm
 * @date 2018/6/19 10:49
 * @desc
 */
public class Oper extends BaseTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void StringKeyAdd() {

    }



}
