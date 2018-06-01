package com.coderme.mq.config;

/**
 * @author qiudm
 * @date 2018/6/1 15:52
 * @desc
 */
public abstract class MqConfig {

    private String password;

    private int host;

    private int port;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
