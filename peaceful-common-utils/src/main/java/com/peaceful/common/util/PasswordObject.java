package com.peaceful.common.util;

import java.io.Serializable;

/**
 * Date 14-10-11.
 * Author WangJun
 * Email wangjuntytl@163.com
 */
public class PasswordObject implements Serializable {

    /**
     * 密码剩余有限期
     */
    public int expireRemainDay = 0;
    /**
     * 是否过期
     */
    public boolean isExpire;

    PasswordObject() {

    }

    void setExpireRemainDay(int expireRemainDay) {
        this.expireRemainDay = expireRemainDay;
        if (this.expireRemainDay < 1)
            this.isExpire = true;
        else
            this.isExpire = false;
    }
}
