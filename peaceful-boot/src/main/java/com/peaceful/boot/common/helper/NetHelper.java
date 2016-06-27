package com.peaceful.boot.common.helper;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wangjun on 16/1/18.
 */
public class NetHelper {

    private final static Logger LOGGER = LoggerFactory.getLogger(NetHelper.class);

    public static String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.error("Error:{} ", e);
        }
        return "NULL";
    }


    public static String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            LOGGER.error("Error: {}", e);
        }
        return "NULL";
    }

    public static boolean ping(String ip, int timeout) {
        try {
            return InetAddress.getByName(ip).isReachable(timeout);
        } catch (IOException e) {
            LOGGER.error("Error: {}", e);
            return false;
        }
    }
}
