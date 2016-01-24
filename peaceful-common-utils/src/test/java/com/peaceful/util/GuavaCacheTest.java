package com.peaceful.util;

import com.google.common.cache.*;
import com.peaceful.common.util.Util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author WangJun <wangjuntytl@163.com>
 * @version 1.0 15/11/18
 * @since 1.6
 */
public class GuavaCacheTest {

    static LoadingCache<String, String> cache;


    static {

        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                // 特别注意,这个是在3秒内屋访问才会清除
                .expireAfterAccess(3,TimeUnit.SECONDS)
                // 这个是在写入3秒后自动过期
//                .expireAfterWrite(3,TimeUnit.SECONDS)
                .removalListener(new CacheRemoveListener())
                .build(
                        new CacheLoader<String, String>() {

                            @Override
                            public String load(String s) throws Exception {
                                // 如果缓存不存在,利用返回值作为value
                                cache.put("hello","world");
                                return "hello world";
                            }
                        });

    }

    static class CacheRemoveListener implements RemovalListener<String, String> {

        @Override
        public void onRemoval(RemovalNotification<String, String> removalNotification) {
            Util.report("Cache Remove Listener:"+removalNotification.getKey() + ":" + removalNotification.getValue() + " cause:"+removalNotification.getCause());
        }
    }


    static Cache<String, String> cache2 = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .removalListener(new CacheRemoveListener())
            .expireAfterWrite(3,TimeUnit.SECONDS)
            .build(); // look Ma, no CacheLoader


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Util.report("get foo:" + cache.get("foo"));
////        cache.put("foo", "bar");
////        Util.report("get foo:" + cache.get("foo"));
//        Thread.sleep(4000);
//        Util.report("get foo:" + cache.get("foo"));

        for (;;) {
//            cache.get("hello");
            Thread.sleep(100);
            String value = cache2.get("hello", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Util.report("-------------");
                    return "world";
                }
            });
            Util.report(value);
        }
    }

}
