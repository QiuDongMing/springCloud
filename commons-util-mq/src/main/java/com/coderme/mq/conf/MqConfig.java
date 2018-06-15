package com.coderme.mq.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author qiudm
 * @date 2018/6/4 15:28
 * @desc
 */
@Configuration
public class MqConfig implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(MqConfig.class);

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    private String host;
    private int port;
    private String username;
    private String password;
    private int connectionTimeOut;
    private int requestedHeartbeat;

    public Environment getEnvironment() {
        return environment;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(int connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }

    public int getRequestedHeartbeat() {
        return requestedHeartbeat;
    }

    public void setRequestedHeartbeat(int requestedHeartbeat) {
        this.requestedHeartbeat = requestedHeartbeat;
    }

    @Bean
    public MqConfig init() {
        this.host = environment.getProperty("mq.host") == null ? "127.0.0.1" : environment.getProperty("mq.host");
        this.port = environment.getProperty("mq.port") == null ? 7562 : Integer.valueOf(environment.getProperty("mq.port"));
        this.username = environment.getProperty("mq.username");
        this.password = environment.getProperty("mq.password");
        this.connectionTimeOut = environment.getProperty("mq.connectionTimeOut") == null ? 20000 : Integer.valueOf(environment.getProperty("mq.connectionTimeOut"));
        this.requestedHeartbeat = environment.getProperty("mq.request.heartbeat") == null ? 60 : Integer.valueOf(environment.getProperty("mq.request.heartbeat"));

        logger.error("this:{}"+this.getHost());
        return this;
    }


}
