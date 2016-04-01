package com.peaceful.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author WangJun
 * @version 1.0 16/3/30
 */
public class SPI {

    private final static Logger LOGGER = LoggerFactory.getLogger(SPI.class);

    public static <T> T search(Class<T> zclass){
        ServiceLoader<T> res = ServiceLoader.load(zclass);
        Iterator<T> search = res.iterator();
        T instance = null;
        int n = 0;
        if (search.hasNext()) {
            instance = search.next();
            LOGGER.info("SPI Find {} -> {}",zclass,instance.getClass().getName());
            n++;
        }
        if (n > 1 ){
            LOGGER.info("find multiple impl for {},active bind impl is {}",zclass,instance.getClass().getName());
        }
        return instance;
    }
}
