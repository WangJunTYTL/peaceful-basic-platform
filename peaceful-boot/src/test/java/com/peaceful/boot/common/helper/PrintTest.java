package com.peaceful.boot.common.helper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class PrintTest {
    @Test
    public void log() throws Exception {
        Console.log(null);
        Console.log(123);
        Console.log("123");
        int[] arr = new int[]{1, 2, 3};
        System.out.println(arr);
        Console.log(arr);
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        Console.log(set);
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        Console.log(list);
        Map<String, Integer> map = Maps.newHashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Console.log(map);
        User user = new User(1, "WJ", 26);
        Console.log("user: %s", user);

    }

}