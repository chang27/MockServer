package com.uci.api;

import com.google.common.collect.Lists;
import com.uci.utils.HttpUtils;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * Created by junm5 on 5/29/17.
 */
public class ServerAppTest {


    private static final String callBack = "http://localhost:9000/callback";

    @Test
    public void name() throws Exception {
        String post = HttpUtils.post(callBack, Lists.newArrayList(
                new BasicNameValuePair("id", "" + 19),
                new BasicNameValuePair("status", "2"),
                new BasicNameValuePair("remark", "finish")
        ));
        System.out.println(post);
    }
}