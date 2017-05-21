package com.uci.mode;

/**
 * Created by junm5 on 5/20/17.
 */
public class Payload {
    private String clint_id;

    public String getClint_id() {
        return clint_id;
    }

    public Payload setClint_id(String clint_id) {
        this.clint_id = clint_id;
        return this;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "clint_id='" + clint_id + '\'' +
                '}';
    }
}
