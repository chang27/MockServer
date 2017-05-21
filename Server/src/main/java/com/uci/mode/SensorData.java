package com.uci.mode;

import java.sql.Timestamp;

/**
 * Created by junm5 on 5/20/17.
 */
public class SensorData {
    private Integer id;
    private Payload payload;
    private Timestamp timestamp;
    private String sensor_id;
    private Integer observation_type_id;


    public Integer getId() {
        return id;
    }

    public SensorData setId(Integer id) {
        this.id = id;
        return this;
    }

    public Payload getPayload() {
        return payload;
    }

    public SensorData setPayload(Payload payload) {
        this.payload = payload;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public SensorData setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getSensor_id() {
        return sensor_id;
    }

    public SensorData setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
        return this;
    }

    public Integer getObservation_type_id() {
        return observation_type_id;
    }

    public SensorData setObservation_type_id(Integer observation_type_id) {
        this.observation_type_id = observation_type_id;
        return this;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", payload=" + payload +
                ", timestamp=" + timestamp +
                ", sensor_id='" + sensor_id + '\'' +
                ", observation_type_id=" + observation_type_id +
                '}';
    }
}
