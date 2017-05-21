package com.uci.api;

import com.uci.mode.Payload;
import com.uci.mode.Response;
import com.uci.mode.SensorData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;

/**
 * Created by junm5 on 5/1/17.
 */
@Component
public class ServerApp {

    @RequestMapping(path = "/query/{id}", method = RequestMethod.GET)
    public Response get(@PathVariable Integer id) {
        return Response.success(new SensorData()
                .setId(id)
                .setObservation_type_id(1)
                .setPayload(new Payload().setClint_id("d6767f4b93cc35ae5f339e5ce5fa268ea11614ce"))
                .setSensor_id("3143-clwa-3039")
                .setTimestamp(Timestamp.valueOf("2017-04-03 12:53:57")));
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public Response post(@RequestBody Integer id) {
        Response ok = Response.success("OK");

        return ok;
    }

}
