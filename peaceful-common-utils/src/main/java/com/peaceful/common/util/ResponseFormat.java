package com.peaceful.common.util;

import java.io.Serializable;

/**
 * Date 14/10/31.
 * Author WangJun
 * Email wangjuntytl@163.com
 * <p/>
 * <h2>API 响应格式</h2>
 */

public class ResponseFormat implements Serializable {

    public int code;
    @Deprecated
    public String result;
    // 使用 data替代result,在javascript中，data在命名上给符合大家默认的规范
    public Object data;

    public String message;

    @Deprecated
    public ResponseFormat(int code, String result) {
        this.code = code;
        this.result = result;
    }

    public ResponseFormat(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseFormat(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
