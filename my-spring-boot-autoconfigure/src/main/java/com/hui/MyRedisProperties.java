package com.hui;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Lance
 * @Date: 2020-10-26 15:11
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "spring.lh.redis")
public class MyRedisProperties {

    private String host;
    private String password;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
