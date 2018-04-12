package com.peaceful.spring.boot.demo.configration;

import com.peaceful.spring.boot.demo.utils.PageResult;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityEngineConf implements ApplicationContextAware {


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        engine.setProperty(RuntimeConstants.ENCODING_DEFAULT, "UTF-8");
        engine.init();
        PageResult.setVelocityEngine(engine);
    }
}
