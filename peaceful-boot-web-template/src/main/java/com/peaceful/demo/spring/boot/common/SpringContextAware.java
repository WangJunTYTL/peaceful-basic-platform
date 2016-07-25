package com.peaceful.demo.spring.boot.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author WangJun
 * @version 1.0 16/6/4
 */
@Component
public class SpringContextAware implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringContextAware.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContext.setSpring(applicationContext);
    }
}
