package com.peaceful.util;

import com.peaceful.common.util.EnvironmentUtils;
import com.peaceful.common.util.Util;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class EnvironmentTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testList() throws Exception {

    }

    @Test
    public void testLogEnv() throws Exception {
        EnvironmentUtils.report();
    }

    @Test
    public void test() {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        String a = "123";
        String b = a;
        identityHashMap.put(a, 2);
        identityHashMap.put(2, 2);
        identityHashMap.put(b, 3);
        Util.report(identityHashMap);
    }

    @Test
    public void testMap() {
        HashMap hashMap = new HashMap<String, Integer>();
        String a = "123";
        String b = a;
        String c = "123";
        Util.report(a == b);
        Util.report(a.equals(b));
        Util.report(a == c);
        Util.report(a.equals(c));
        hashMap.put(a, 2);
        hashMap.put(2, 2);
        hashMap.put(b, 3);
        hashMap.put(null, 3);
        hashMap.put(6, 3);
        Util.report(hashMap);
        Util.report(hashMap.keySet());
    }

    @Test
    public void testhasp(){
        Integer a = new Integer(123456);
        Integer b = new Integer(123456);
        Util.report(a == b );
        HashMap hashMap = new HashMap();
        hashMap.put(a,1);
        hashMap.put(b, 2);
        IdentityHashMap identityHashMap = new IdentityHashMap();
        identityHashMap.put(a,1);
        identityHashMap.put(b,2);
        Util.report(hashMap);
        Util.report(identityHashMap);
    }
}