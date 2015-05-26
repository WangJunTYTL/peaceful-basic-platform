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
     cache = CacheImpl.getCache(5, new CacheCallback() {
         @Override
         public Object callback() {
             return "";
         }
     });
    }

    @Test
    public void testPut() throws Exception {
        cache.put("key","value");
        cache.put("key",null);
        cache.put("key2","value");
        cache.put("key3", new Date());
        Util.report("key -> " + cache.get("key", String.class));
        cache.clear("key2");
//        Thread.sleep(8000);
        Util.report("key2 -> " + cache.get("key2", String.class));
        Util.report("key3 -> " + cache.get("key3",Date.class));
        cache.clearAll();
        Util.report(cache.get("key",String.class));

    }

    @Test
    public void testGet() throws Exception {
        Util.report(cache.get("key",String.class));
    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testClearAll() throws Exception {

    }
}