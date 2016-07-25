package com.peaceful.demo.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 1. 支持xml配置bean  spring boot 的application context实现是AnnotationConfigApplicationContext
 */

@SpringBootApplication //该包下面的所有类都会被扫描
@EnableScheduling // 允许执行定时任务
@ImportResource("classpath:/applicationContext.xml")
@ServletComponentScan // 可以扫描servlet 注解
// 开发指南： http://spring.io/guides
public class Application extends SpringBootServletInitializer { // 这里继承这个类是为了打包后可以部署到tomcat中

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
