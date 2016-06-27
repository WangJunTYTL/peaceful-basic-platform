package com.peaceful.boot.demo;

import com.peaceful.boot.Application;

import java.util.concurrent.TimeUnit;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class SetUp {

    public static void main(String[] args) throws InterruptedException {
        Application.loadToJVM();
        for (; ; ) {

//            Alert.notice(new Message("接口超时", "/xx/xx：响应时间在60s以上", MsgSentTypeEnum.SMS));
//            Alert.notice(new Message("接口超时", "/xx/xx：响应时间在60s以上", MsgSentTypeEnum.ALL));
//            Metric.counter("/xx/xx", "$c>0", new Message("$t超时", "在$i内$t超时出现$c次，超时规则$t>100ms", MsgLevelEnum.WARN));
            TimeUnit.SECONDS.sleep(6);
        }
    }
}
