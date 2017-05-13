package com.uci.api;

import com.uci.mode.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by junm5 on 5/1/17.
 */
@Component
public class ServerApp implements IServer {

    private String DEFAULT_REPLY = "OK";

    @Override
    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public Response ping() {
        return Response.success("OK");
    }
}
