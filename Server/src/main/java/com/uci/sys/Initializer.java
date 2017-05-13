package com.uci.sys;

import com.uci.mode.Response;
import com.uci.utils.HttpUtils;
import com.uci.utils.JsonUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 5/1/17.
 */
@Component
public class Initializer {

//    @Autowired
//    private ApplicationRepository applicationRepository;

    @PostConstruct
    public void init() {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            Integer port = 9000;
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("ip", ip));
            params.add(new BasicNameValuePair("port", String.valueOf(port)));
            String response = HttpUtils.post("http://localhost:8080/loadbalancer/register", params);
            Response respo = JsonUtils.toObject(response, Response.class);
            if (respo.getCode().equals("200")) {
                System.out.println("register successfully!!!");
            } else {
                System.out.println("register failed...!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
