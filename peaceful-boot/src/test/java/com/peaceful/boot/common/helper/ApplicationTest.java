package com.peaceful.boot.common.helper;

import com.peaceful.boot.Application;
import org.junit.Test;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class ApplicationTest {
    @Test
    public void loadToJVM() throws Exception {
        Application.loadToJVM();
//        TimeUnit.HOURS.sleep(1);
    }

    @Test
    public void getConfigContext() throws Exception {

    }

    @Test
    public void getStartDate() throws Exception {
        Console.log("start date: %s", Application.getStartDate());
    }

    @Test
    public void getRunningEnv() throws Exception {
        Console.log("running.env: %s", Application.getRunningEnv());
    }

    @Test
    public void isDev() throws Exception {
        Console.log("isDev: %s",Application.isDev());
    }

    @Test
    public void isTest() throws Exception {
        Console.log("isTest: %s",Application.isTest());
    }

    @Test
    public void isProduct() throws Exception {
        Console.log("isProduct: %s",Application.isProduct());
    }

}