package com.peaceful.common.util;

/**
 * Date 14/10/21.
 * Author WangJun
 * Email wangjuntytl@163.com
 *
 *
 */
public interface Cache {

    final String EMPTY="this_cache_is_empty";

    Object get(Object key);

    void put(Object key, Object value);

    void clear(Object key);

    void clearAll();
}