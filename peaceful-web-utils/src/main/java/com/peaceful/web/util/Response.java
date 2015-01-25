package com.peaceful.web.util;

import java.io.Serializable;

/**
 * Date 14/10/31.
 * Author WangJun
 * Email wangjuntytl@163.com
 * <p/>
 * <h2>最常用的返回浏览器端json数据</h2>
 */

public class Response implements Serializable {
    public int code;
    public String result;

    public Response(int code, String result) {
        this.code = code;
        this.result = result;
    }
}
