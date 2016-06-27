package com.peaceful.boot.common.helper;

import org.junit.Test;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class NetHelperTest {
    @Test
    public void getIp() throws Exception {
        Console.log("ip: %s", NetHelper.getIp());
    }

    @Test
    public void getHostname() throws Exception {
        Console.log("host: %s", NetHelper.getHostname());
    }

    @Test
    public void ping() throws Exception {
        Console.log(NetHelper.ping("127.0.0.1", 3));
    }

}