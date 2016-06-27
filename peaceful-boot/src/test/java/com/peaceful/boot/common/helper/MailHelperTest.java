package com.peaceful.boot.common.helper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class MailHelperTest {
    @Test
    public void send() throws Exception {
        MailHelper.send("wangjuntytl@163.com", "test", "hello world!");
    }

}