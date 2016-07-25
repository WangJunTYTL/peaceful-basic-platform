package com.peaceful.demo.spring.boot.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author WangJun
 * @version 1.0 16/7/23
 */
public class ConfigDemo2 {

    public String a;

    public void setA(String a) {
        this.a = a;
    }
}
