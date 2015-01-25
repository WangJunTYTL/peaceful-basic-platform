package com.peaceful.config.util;

import com.peaceful.common.util.StringUtils;
import com.peaceful.common.util.Util;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class StringUtilsTest {

    @Test
    public void testIndexFrom() throws Exception {
        Util.report(StringUtils.indexFrom("abcd", "dd") + "");
    }

    @Test
    public void testContains() throws Exception {
        Util.report(StringUtils.contains("abcd", "ad") + "");
    }


    @Test
    public void test(){
        SortedMap<Integer,String> sortedMap = new TreeMap<Integer, String>();
        sortedMap.put(6,"a");
        sortedMap.put(5,"b");
        sortedMap.put(7,"r");
        sortedMap.put(8,"a");

        Util.report(sortedMap);
    }
}