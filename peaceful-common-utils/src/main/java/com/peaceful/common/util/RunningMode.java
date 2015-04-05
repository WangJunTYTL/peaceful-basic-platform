package com.peaceful.common.util;

/**
 * <a mailto:wangjuntytl@163.com>Email:wangjuntytl@163.com</a>
 *
 * @author wangjun
 * @version 1.0
 * @since 15/4/5.
 */

public enum RunningMode {

    DEV("dev"), TEST("test"), PRODUCT("product");

    private final String value;

    RunningMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RunningMode fromValue(String value) {
        if ("dev".equals(value)) return DEV;
        if ("test".equals(value)) return TEST;
        if ("product".equals(value)) return PRODUCT;
        throw new RuntimeException("Invalid  value for conversion to EventType");
    }


}
