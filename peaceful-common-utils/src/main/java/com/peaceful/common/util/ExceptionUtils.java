package com.peaceful.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author WangJun <wangjuntytl@163.com>
 * @version 1.0 15/10/13
 * @since 1.6
 */

public class ExceptionUtils {

    /**
     * 完整的堆栈信息
     *
     * @param e Exception
     * @return Full StackTrace
     */
    public static String getStackTrace(Exception e) {
        Throwable throwable = e;
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            unwrapThrowable(throwable).printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }


    public static Throwable unwrapThrowable(Throwable wrapped) {
        Throwable unwrapped = wrapped;
        while (true) {
            if (unwrapped instanceof InvocationTargetException) {
                unwrapped = ((InvocationTargetException) unwrapped).getTargetException();
            } else if (unwrapped instanceof UndeclaredThrowableException) {
                unwrapped = ((UndeclaredThrowableException) unwrapped).getUndeclaredThrowable();
            } else {
                return unwrapped;
            }
        }
    }
}
