package com.peaceful.common.util;

import com.peaceful.common.util.impl.AppConfigsImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Obtain information on the program is running environment
 * @see RunningMode
 *
 * @author WangJun <wangjuntytl@163.com>
 * @version 1.0  14/10/21.
 * @since 1.6
 */
public class Application {

    private static AppConfigs appConfigs = AppConfigsImpl.getMyAppConfigs("application.properties");
    private static long startTime = System.currentTimeMillis();


    public static void loadToJVM() {
        // nothing to do ,just to load the class to JVM
        // you  must to load the class to JVM at once when your app start,ensure get a right start time
    }

    /**
     * The program running environment is dev environment ?
     *
     * @return
     */
    public static boolean isDev() {
        String mode = appConfigs.getString("running.mode");
        if (mode.equals("dev"))
            return true;
        else
            return false;
    }

    /**
     * The program running environment is test environment ?
     *
     * @return
     */
    public static boolean isTest() {
        String mode = appConfigs.getString("running.mode");
        if (mode.equals("test"))
            return true;
        else
            return false;
    }

    /**
     * The program running environment is product environment ?
     *
     * @return
     */
    public static boolean isProduct() {
        String mode = appConfigs.getString("running.mode");
        if (mode.equals("product"))
            return true;
        else
            return false;
    }

    /**
     * get running time ,but you need ensure the class can be loaded to jvm  when your program start
     *
     * @return
     */
    public static long getRunningTime() {
        return System.currentTimeMillis() - startTime;
    }

    /**
     * get running environment
     *
     * @return
     */
    public static RunningMode getRunningMode() {
        return RunningMode.fromValue(appConfigs.getString("running.mode"));
    }

    /**
     * get maven build time as the version number
     *
     * @return build timestamp
     */
    public static String getBuildVersion() {
        return appConfigs.getString("build.version");
    }

    public static String out() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[{");
        buffer.append("\"");
        buffer.append("running.time");
        buffer.append("\"");
        buffer.append(":");
        buffer.append(getRunningTime());
        buffer.append(",");
        buffer.append("\"running.mode\":");
        buffer.append("\"");
        buffer.append(getRunningMode().name());
        buffer.append("\"");
        buffer.append(",");
        buffer.append("\"host.name\":");
        try {
            buffer.append("\"");
            buffer.append(InetAddress.getLocalHost().getCanonicalHostName());
            buffer.append("\"");
        } catch (UnknownHostException e) {
            buffer.append("\"<NA>\"");
        }
        buffer.append(",");
        buffer.append("\"");
        buffer.append("build.version");
        buffer.append("\"");
        buffer.append(":");
        buffer.append(getBuildVersion());
        buffer.append("}]");
        return buffer.toString();
    }
}
