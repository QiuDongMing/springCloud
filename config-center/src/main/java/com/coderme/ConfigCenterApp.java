package com.coderme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author qiudm
 * @date 2018/6/15 10:50
 * @desc
 */
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApp.class, args);
    }

}
