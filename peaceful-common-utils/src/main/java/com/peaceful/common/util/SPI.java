package com.peaceful.common.util;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author WangJun
 * @version 1.0 16/3/30
 */
public class SPI {

    private final static Logger LOGGER = LoggerFactory.getLogger(SPI.class);

    @Deprecated
    public static <T> T search(Class<T> zclass) {
        ServiceLoader<T> res = ServiceLoader.load(zclass);
        Iterator<T> search = res.iterator();
        T instance = null;
        int n = 0;
        if (search.hasNext()) {
            instance = search.next();
            LOGGER.info("SPI Find {} -> {}", zclass, instance.getClass().getName());
            n++;
        }
        if (n > 1) {
            LOGGER.info("find multiple impl for {},active bind impl is {}", zclass, instance.getClass().getName());
        }
        return instance;
    }

    /**
     * 按照类的加载顺序返回第一个被加载的实现类
     *
     * @param zclass
     * @param <T>
     * @return 假如没有发现返回null
     */
    public static <T> T selectOne(Class<T> zclass) {
        List<T> instances = selectList(zclass);
        if (instances != null && instances.size() == 1) {
            return instances.get(0);
        } else if (instances != null && instances.size() > 1) {
            LOGGER.warn("find {} has multi implements,actual binding is {}", instances.get(0).getClass().getName());
            return instances.get(0);
        } else {
            return null;
        }
    }

    /**
     * 返回所有的实现类集合
     *
     * @param zclass
     * @param <T>
     * @return 假如没有发现，返回一个size为0的空集合
     */
    public static <T> List<T> selectList(Class<T> zclass) {
        ServiceLoader<T> res = ServiceLoader.load(zclass);
        Iterator<T> search = res.iterator();
        T instance = null;
        List<T> instances = Lists.newArrayList();
        if (search.hasNext()) {
            instance = search.next();
            instances.add(instance);
            LOGGER.info("SPI: {} -> {}", zclass, instance.getClass().getName());
        }
        return instances;
    }


}
