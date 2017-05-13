//package com.uci.conf;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
///**
// * Created by junm5 on 5/1/17.
// */
//@Configuration
//@PropertySource("file:application.properties")
//public class ApplicationRepository {
//
//    @Value("${load.balance.ip}")
//    private String loadBalanceIp;
//    @Value("${load.balance.port}")
//    private Integer loadBalancePort;
//    @Value("${server.port}")
//    private Integer selfPort;
//
//    public Integer getSelfPort() {
//        return selfPort;
//    }
//
//    public void setSelfPort(Integer selfPort) {
//        this.selfPort = selfPort;
//    }
//
//    public String getLoadBalanceIp() {
//        return loadBalanceIp;
//    }
//
//    public void setLoadBalanceIp(String loadBalanceIp) {
//        this.loadBalanceIp = loadBalanceIp;
//    }
//
//    public Integer getLoadBalancePort() {
//        return loadBalancePort;
//    }
//
//    public void setLoadBalancePort(Integer loadBalancePort) {
//        this.loadBalancePort = loadBalancePort;
//    }
//}
