package com.peaceful.demo.spring.boot.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author WangJun
 * @version 1.0 16/7/23
 */
@Configuration
@PropertySource("classpath:/my_config.properties")
public class ConfigDemo {

    @Value("${a}")
    public String a;

    @Value("${b}")
    public int b;

    public int c;

    public void setC(int c) {
        this.c = c;
    }
}
