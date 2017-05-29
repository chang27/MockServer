package com.uci.mode;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("details")
public class InstanceDetails {

    private Integer freeMemory;
    private Integer availableProcessor;
    ;

    public InstanceDetails() {

    }

    public Integer getFreeMemory() {
        return freeMemory;
    }

    public InstanceDetails setFreeMemory(Integer freeMemory) {
        this.freeMemory = freeMemory;
        return this;
    }

    public Integer getAvailableProcessor() {
        return availableProcessor;
    }

    public InstanceDetails setAvailableProcessor(Integer availableProcessor) {
        this.availableProcessor = availableProcessor;
        return this;
    }

    @Override
    public String toString() {
        return "InstanceDetails{" +
                "freeMemory=" + freeMemory +
                ", availableProcessor=" + availableProcessor +
                '}';
    }
}