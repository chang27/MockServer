package com.uci.mode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by junm5 on 5/27/17.
 */
@Component
public class DesProperties {

    @Value("${server.port}")
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
