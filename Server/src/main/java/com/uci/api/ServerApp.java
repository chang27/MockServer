package com.uci.api;

import com.google.common.collect.Lists;
import com.uci.mode.*;
import com.uci.utils.HttpUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by junm5 on 5/1/17.
 */
@RestController
public class ServerApp {
    private final static int mb = 1024 * 1024;
    private ExecutorService es = Executors.newCachedThreadPool();

    private static final String callBack = "/callback";

    @Autowired
    private DesProperties desProperties;

    @RequestMapping(path = "/query/{id}", method = RequestMethod.GET)
    public Response get(@PathVariable Integer id) {
        return Response.success(new SensorData()
                .setId(id)
                .setObservation_type_id(1)
                .setPayload(new Payload().setClint_id("d6767f4b93cc35ae5f339e5ce5fa268ea11614ce"))
                .setSensor_id("3143-clwa-3039")
                .setTimestamp(Timestamp.valueOf("2017-04-03 12:53:57")));
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public Response post(@RequestParam Integer requestId, @RequestParam Integer id) {
        Response ok = Response.success("OK");
        Future<Integer> f = es.submit(() -> {
            Thread.sleep(2000);

            HttpUtils.post(callBack, Lists.newArrayList(
                    new BasicNameValuePair("id", "" + requestId),
                    new BasicNameValuePair("status", "2"),
                    new BasicNameValuePair("remark", "finish")
            ));

            return 100;
        });
        return ok;
    }

    @RequestMapping(path = "/queryParams", method = RequestMethod.GET)
    public Response queryParams() {

        Runtime instance = Runtime.getRuntime();

        Integer freeMen = (int) instance.freeMemory() / mb;
        return Response.success(new ServerInstance()
                .setFreeMemory(freeMen)
                .setPort(desProperties.getPort())
                .setAvailableProcessor(instance.availableProcessors()));

    }

}
