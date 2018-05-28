package com.coderme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author qiudm
 * @date 2018/5/28 13:42
 * @desc
 */
@SpringBootApplication
@EnableZuulProxy
public class GateWayApp {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApp.class, args);
    }


}
