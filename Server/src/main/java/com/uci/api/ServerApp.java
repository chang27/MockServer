package com.uci.api;

import com.uci.mode.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by junm5 on 5/1/17.
 */
@Component
public class ServerApp {

    private String DEFAULT_REPLY = "OK";

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Response get() {
        return Response.success(DEFAULT_REPLY);
    }


    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public Response post() {
        return Response.success("OK");
    }


    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public Response ping() {
        return Response.success(DEFAULT_REPLY);
    }
}
