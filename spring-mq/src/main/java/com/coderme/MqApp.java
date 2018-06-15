package com.coderme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiudm
 * @date 2018/5/21 21:58
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class MqApp {

    public static void main(String[] args) {
        SpringApplication.run(MqApp.class, args);
    }


}
