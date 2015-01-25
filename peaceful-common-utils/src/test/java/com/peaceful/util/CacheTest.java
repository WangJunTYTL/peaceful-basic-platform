package com.peaceful.util;

import com.peaceful.common.util.Cache;
import com.peaceful.common.util.Util;
import com.peaceful.common.util.impl.CacheCallback;
import com.peaceful.common.util.impl.CacheImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class CacheTest {
    Cache cache;

    @Before
    public void befor(){
     cache = CacheImpl.getCache(30 * 60, new CacheCallback() {
         @Override
         public Object callback() {
             return "this_cache_is_empty";
         }
     });
    }

    @Test
    public void testPut() throws Exception {
        cache.put("key","value");
        cache.put("key",null);
        cache.put("key2","value");
        cache.put("key3", new Date());
        Util.report(cache.get("key"));
        cache.clear("key2");
        Util.report(cache.get("key"));
        Util.report(cache.get("key2"));
        Util.report(cache.get("key3"));
        cache.clearAll();
        Util.report(cache.get("key"));

    }

    @Test
    public void testGet() throws Exception {
        Util.report(cache.get("key"));
    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testClearAll() throws Exception {

    }
}