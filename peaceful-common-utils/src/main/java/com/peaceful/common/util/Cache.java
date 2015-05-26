package com.peaceful.common.util;

/**
 * Date 14/10/21.
 * Author WangJun
 * Email wangjuntytl@163.com
 */
public interface Cache {


    <T> T get(String key,Class<T> requiredType);

    void put(Object key, Object value);

    void clear(Object key);

    void clearAll();
}