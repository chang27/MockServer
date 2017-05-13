package com.uci.conf;

import discovery.InstanceDetails;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by junm5 on 5/11/17.
 */
@Component
public class Registry {

    private ServiceDiscovery<InstanceDetails> serviceDiscovery;
    private ServiceInstance<InstanceDetails> thisInstance;

    private final static int port = 8000;
    private static final String BASIC_SCHEME = "{scheme}://localhost:{port}";
    private CuratorFramework client;
    private static final String PATH = "/discovery/";
    private RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

    private static final String connection = "localhost:2181";

    @PostConstruct
    public void init() throws Exception {
        String localIP = getLocalIP();
        String scheme = buildScheme(localIP);
        UriSpec uriSpec = new UriSpec(scheme);

        client = CuratorFrameworkFactory.newClient(connection, retryPolicy);

        thisInstance = ServiceInstance.<InstanceDetails>builder()
                .name(scheme)
                .payload(new InstanceDetails())
                .port(port) // in a real application, you'd use a common port
                .uriSpec(uriSpec)
                .build();

        JsonInstanceSerializer<InstanceDetails> serializer = new JsonInstanceSerializer<InstanceDetails>(InstanceDetails.class);

        serviceDiscovery = ServiceDiscoveryBuilder.builder(InstanceDetails.class)
                .client(client)
                .basePath(PATH)
                .serializer(serializer)
                .thisInstance(thisInstance)
                .build();

        client.start();
        serviceDiscovery.start();
        System.out.println(scheme + " register success!!!");
    }

    private static String buildScheme(String ip) {
        return BASIC_SCHEME.replace("localhost", ip).replace("port", "" + port);
    }

    private static String getLocalIP() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    //close all connections
    @PreDestroy
    public void unregisterService() {
        CloseableUtils.closeQuietly(serviceDiscovery);
        CloseableUtils.closeQuietly(client);
    }
}
