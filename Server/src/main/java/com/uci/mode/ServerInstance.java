package com.uci.mode;

/**
 * Created by junm5 on 5/27/17.
 */
public class ServerInstance {
    private String ip;
    private Integer port;
    
    private Integer freeMemory;
    private Integer availableProcessor;

    public Integer getFreeMemory() {
        return freeMemory;
    }

    public ServerInstance setFreeMemory(Integer freeMemory) {
        this.freeMemory = freeMemory;
        return this;
    }

    public Integer getAvailableProcessor() {
        return availableProcessor;
    }

    public ServerInstance setAvailableProcessor(Integer availableProcessor) {
        this.availableProcessor = availableProcessor;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public ServerInstance setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public ServerInstance setPort(Integer port) {
        this.port = port;
        return this;
    }

    @Override
    public String toString() {
        return "ServerInstance{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", freeMemory=" + freeMemory +
                ", availableProcessor=" + availableProcessor +
                '}';
    }
}
