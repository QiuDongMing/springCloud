package com.coderme.demo;

import com.coderme.auth.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Objects;

/**
 * @author qiudm
 * @date 2018/6/6 15:43
 * @desc
 */
public class RedisTest extends BaseTest {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void addTest() {
//        String key = "qdm:1001";
//        Long bus = template.opsForHash().increment(key, "bus", -1);
//        System.out.println("bus = " + bus);


        String key = "qdm:test:1";
        template.opsForValue().set(key, "1");

    }


    @Test
    public void reduTest() {

        String key = "qdm:test:1";
        Long increment = template.opsForValue().increment(key, -1);
        System.out.println("increment = " + increment);
        if(Objects.nonNull(increment) && increment < 0) {
            template.opsForValue().set(key, "0");
        }

        System.out.println("increment = " + increment);
    }



    @Test
    public void setKeyTest() {

    }













}
