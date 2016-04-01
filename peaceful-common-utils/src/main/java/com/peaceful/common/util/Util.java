package com.peaceful.common.util;


import java.lang.reflect.Array;
import java.util.Date;

/**
 * An internal utility class.
 *
 * @author WangJun <wangjuntytl@163.com>
 * @version 1.0  14/10/21.
 * @since 1.6
 */
public abstract class Util {


    static final public void report(String msg, Throwable t) {
        System.err.println(msg);
        System.err.println("Reported exception:");
        t.printStackTrace();
    }

    private static final String prefix = "P_LOG:";

    static final public void report(String msg) {
        System.err.println("P_LOG: " + msg);
    }

    static final public void report(boolean msg) {
        System.err.println("P_LOG: " + msg);
    }

    static final public void report(Integer msg) {
        System.err.println("P_LOG: " + msg);
    }

    static final public void report(int msg) {
        System.err.println("P_LOG: " + msg);
    }

    static final public void report(Object object) {
        if (object.getClass().isArray()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("Array:[");
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                buffer.append(Array.get(object, i));
                if (i == length - 1) {
                    // pass
                } else {
                    buffer.append(",");
                }
            }
            buffer.append("]");
            out(buffer.toString());
        } else {
            out(object.toString());
        }
    }

    static final public void enter() {
        out("");
    }

    static final public void dashed() {
        out("-------------------------------");
    }

    static private void out(String str) {
        System.err.println(prefix+DateUtils.formatDateTime(new Date())+" "+str);
    }


}
