package com.peaceful.boot.common.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class Console {

    public final static String PREFIX = "Console Log: ";

    /**
     * 控制台log，替代System.out.println(...),支持多种类型的友好输出
     */
    public static void log(Object o) {
        String date = DateHelper.formatDateTime(new Date());
        if (o == null) {
            System.out.println(PREFIX + "[" + date + "] " + "NULL");
        } else if (o.getClass().isPrimitive()) { // 原语类型
            System.out.println(PREFIX + "[" + date + "] " + o);
        } else if (o.getClass().isArray()) { // 数组类型
            int length = Array.getLength(o);
            StringBuffer buffer = new StringBuffer();
            buffer.append("[");
            for (int i = 0; i < length; i++) {
                buffer.append(Array.get(o, i));
                if (i != length - 1) {
                    buffer.append(", ");
                }
            }
            buffer.append("]");
            System.out.println(PREFIX + "[" + date + "] " + buffer);
        } else if (o instanceof Collection) { // 集合类型
            System.out.println(PREFIX + "[" + date + "] " + o);
        } else if (o instanceof Map) { // 集合类型
            System.out.println(PREFIX + "[" + date + "] " + o);
        } else {
            System.out.println(PREFIX + "[" + date + "] " + JSON.toJSONString(o, SerializerFeature.WriteDateUseDateFormat));
        }
    }

    /**
     * 参数模板格式："message:%s","content"
     */
    public static void log(String messageFormat, Object... args) {
        String date = DateHelper.formatDateTime(new Date());
        System.out.println(PREFIX + "[" + date + "] " + format(messageFormat, args));
    }

    /**
     * Substitutes each {@code %s} in {@code template} with an argument. These are matched by
     * position: the first {@code %s} gets {@code args[0]}, etc.  If there are more arguments than
     * placeholders, the unmatched arguments will be appended to the end of the formatted message in
     * square braces.
     *
     * @param template a non-null string containing 0 or more {@code %s} placeholders.
     * @param args     the arguments to be substituted into the message template. Arguments are converted
     *                 to strings using {@link String#valueOf(Object)}. Arguments can be null.
     */
    public static String format(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }

        return builder.toString();
    }
}
