package com.peaceful.boot.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.peaceful.boot.alert.msg.AbstractCloudMsgQueue;
import com.peaceful.boot.alert.msg.MsgConfig;
import com.peaceful.boot.alert.msg.Message;
import com.peaceful.boot.common.helper.Console;
import com.peaceful.common.redis.service.Redis;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class AlertImpl extends AbstractCloudMsgQueue {

    private static final String KEY = "ALERT_MSG_CLOUD_MERGE_" + MsgConfig.applicationName;

    public void push(Message message) {
        Redis.cmd().rpush(KEY, JSON.toJSONString(message));
    }

    public List<Message> pop(int size) {
        List<String> msgs = Lists.newLinkedList();
        String msg = Redis.cmd().rpop(KEY);
        for (int i = 0; i < MsgConfig.maxSize; i++) {
            if (StringUtils.isBlank(msg)) {
                break;
            } else {
                msgs.add(msg);
                msg = Redis.cmd().rpop(KEY);
            }
        }
        // 本次merge不掉的消息直接忽略
        if (msg != null) {
            Redis.cmd().del(KEY);
        }
        List<Message> messageList = Lists.newArrayList();
        for (String m : msgs) {
            messageList.add(JSON.parseObject(m, Message.class));
        }
        return messageList;
    }

    public boolean isMaster() {
        return true;
    }

    public void sendSms(List<Message> messages) {
        Console.log("send sms...");
    }
}
