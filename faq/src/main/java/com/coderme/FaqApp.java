package com.coderme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author qiudm
 * @date 2018/5/21 21:58
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class FaqApp {

    public static void main(String[] args) {
        SpringApplication.run(FaqApp.class, args);
    }


}
