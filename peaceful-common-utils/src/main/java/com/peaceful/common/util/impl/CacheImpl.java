package com.peaceful.common.util.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.peaceful.common.util.Cache;
import com.peaceful.common.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Date 14/10/21.
 * Author WangJun
 * Email wangjuntytl@163.com
 *
 * 基于Google guava包提供的缓存工具
 */
public class CacheImpl implements Cache {

    private final static Logger logger = LoggerFactory.getLogger(Cache.class);

    private LoadingCache loadingCache = null;

    private CacheImpl(){

    }

    public static Cache getCache(long expire, final CacheCallback cacheCallback) {
        CacheImpl cache = new CacheImpl();
        if (cache.loadingCache == null) {
            cache.loadingCache = CacheBuilder.newBuilder().expireAfterAccess(expire, TimeUnit.SECONDS)
                    .build(
                            new CacheLoader<String, Object>() {
                                public Object load(String key) { // no checked exception
                                    return cacheCallback.callback(); // 假如缓存不存在，去加载，这里只是模拟
                                }
                            });
        }
        return cache;
    }


    public void put(Object key, Object value) {
        Util.report(loadingCache);
        Util.report(key);
        Util.report(value);
        if (value == null)
            return;
        loadingCache.put(key, value);
    }

    public Object get(Object key) {
        try {
            if (loadingCache.size() != 0) {
                if (loadingCache.get(key).equals(CacheImpl.EMPTY)){
                    return null;
                }
                return loadingCache.get(key);
            }
        } catch (ExecutionException e) {
            logger.error("get:{}", e);
        }
        return null;
    }

    public void clear(Object key) {
        loadingCache.invalidate(key);
    }


    public void clearAll() {
        loadingCache.invalidateAll();
    }
}
