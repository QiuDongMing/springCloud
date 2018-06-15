package com.coderme.mq;

import com.coderme.mq.conf.MqConfig;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;

/**
 * @author qiudm
 * @date 2018/6/4 15:02
 * @desc
 */
@Scope("singleton")
@Component
public class ConnectionManager {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionManager.class);

    private static ConnectionManager manager = null;

    private ConnectionManager() {
        manager = this;
    }

    public static ConnectionManager getInstance() {
        return manager;
    }

    @Autowired
    private MqConfig mqConfig;

    public Connection newConnection(ThreadFactory facotry, int timeout) {
        ConnectionFactory factory = this.getConnectionFactory();
        if(facotry != null) {
            factory.setThreadFactory(facotry);
        }
        Connection connection = null;
        long startTime = System.currentTimeMillis();

        while(connection == null) {
            try {
                if(timeout > 0 && System.currentTimeMillis() - startTime > (long)timeout) {
                    logger.error("rabbitmq connect is timeout!");
                    return null;
                }
                connection = factory.newConnection();
            } catch (TimeoutException var12) {
                logger.error(var12.getMessage());
            } catch (Throwable var13) {
                connection = null;
                logger.error(var13.getMessage());
            }

            if(connection == null) {
                try {
                    Thread.sleep(2000L);
                } catch (Throwable var11) {
                    logger.error(var11.getMessage());
                }
            }
        }

        connection.addShutdownListener(new ShutdownListener() {
            public void shutdownCompleted(ShutdownSignalException cause) {
                String hardError = "";
                String applInit = "";
                if(cause.isHardError()) {
                    hardError = "connection";
                } else {
                    hardError = "channel";
                }

                if(cause.isInitiatedByApplication()) {
                    applInit = "application";
                } else {
                    applInit = "broker";
                }

                ConnectionManager.logger.warn("Connectivity to MQ has failed.  It was caused by {} at the {} level.  Reason received {}", new Object[]{hardError, applInit, cause.getReason()});
            }
        });
        return connection;
    }


    private ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(mqConfig.getHost());
        connectionFactory.setPort(mqConfig.getPort());
        connectionFactory.setUsername(mqConfig.getUsername());
        connectionFactory.setPassword(mqConfig.getPassword());
        connectionFactory.setConnectionTimeout(mqConfig.getConnectionTimeOut());
        connectionFactory.setRequestedHeartbeat(mqConfig.getRequestedHeartbeat());
        connectionFactory.setAutomaticRecoveryEnabled(true);
        connectionFactory.setNetworkRecoveryInterval(5000);
        return connectionFactory;
    }


}
