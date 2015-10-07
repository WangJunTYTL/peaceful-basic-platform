package com.peaceful.common.util;


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
        System.err.println("P_LOG: " +object.toString());
    }

    static final public void enter() {
        out("");
    }

    static final public void dashed() {
        out("-------------------------------");
    }

    static private void out(String str) {
        System.err.println(str);
    }

}
