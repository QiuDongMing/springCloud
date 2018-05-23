package com.coderme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author qiudm
 * @date 2018/5/23 19:19
 * @desc
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients//开启fegin远程调用其他服务
public class AuthApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }

}
