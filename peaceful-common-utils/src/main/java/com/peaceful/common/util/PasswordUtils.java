package com.peaceful.common.util;

import java.util.Date;

/**
 * Date 14-10-11.
 * Author WangJun
 * Email wangjuntytl@163.com
 */
public class PasswordUtils {

    /**
     *
     * @param lastUpdateTime 密码最近更新时间
     * @param expireDay 有效期
     * @return
     */
    public static PasswordObject getPasswordObject(Date lastUpdateTime,int expireDay) {
        PasswordObject passwordObject = new PasswordObject();
        passwordObject.setExpireRemainDay(expireDay - (int) ((System.currentTimeMillis() - lastUpdateTime.getTime()) / (24 * 60 * 60 * 1000)));
        return passwordObject;
    }

}
