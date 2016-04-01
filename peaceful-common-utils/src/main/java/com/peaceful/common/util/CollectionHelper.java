package com.peaceful.common.util;

/**
 * @author WangJun
 * @version 1.0 16/4/1
 */
public class CollectionHelper {

    public static String arrayToString(Object[] args){
        if (args == null || args.length == 0 ){
            return "[]";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (Object o:args){
            buffer.append(o).append(",");
        }
        return buffer.substring(0,buffer.length()-1)+"]";
    }
}
