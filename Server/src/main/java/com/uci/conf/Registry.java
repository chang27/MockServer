package com.uci.conf;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.imageio.spi.ServiceRegistry;

/**
 * Created by junm5 on 5/11/17.
 */
@Component
public class Registry {
    @Autowired
    private ServiceRegistry services;

    private static final String ZOO_KEEPER_CONF = "localhost:2181";

    private static final String endpointURI = "http://localhost:8080/catalog/resources/catalog";
    private static final String serviceName = "catalog";

    @PostConstruct
    public void registerService() {
//        CuratorFramework client = CuratorFrameworkFactory.newClient(ZOO_KEEPER_CONF, new ExponentialBackoffRetry(1000, 3));
//        client.start();

    }

    @PreDestroy
    public void unregisterService() {
//        services.unregisterService(serviceName, endpointURI);
    }


}
