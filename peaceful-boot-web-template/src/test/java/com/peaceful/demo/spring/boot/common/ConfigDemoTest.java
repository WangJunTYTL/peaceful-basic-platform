package com.peaceful.demo.spring.boot.common;

import com.peaceful.demo.spring.boot.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author WangJun
 * @version 1.0 16/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ConfigDemo.class)
@SpringApplicationConfiguration(Application.class)
public class ConfigDemoTest {

    @Autowired
    ConfigDemo configDemo;



    @org.junit.Test
    public void getA() throws Exception {
        System.out.println(configDemo.a);
        System.out.println(configDemo.b);
        System.out.println(configDemo.c);
    }

}