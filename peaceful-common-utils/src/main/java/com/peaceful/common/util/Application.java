package com.peaceful.common.util;

import com.peaceful.common.util.impl.AppConfigsImpl;

/**
 * Date 14/10/28.
 * Author WangJun
 * Email wangjuntytl@163.com
 * <p/>
 * <h3>web app 全局配置信息</h3>
 */
public class Application {

    private static AppConfigs appConfigs = AppConfigsImpl.getMyAppConfigs("application.properties");

    private static long startTime = System.currentTimeMillis();

    /**
     * 项目是否在dev环境运行
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
     * 项目是否在test环境运行
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
     * 项目是否在product环境运行
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

    public static long getRunningTime() {
        return System.currentTimeMillis() - startTime;
    }

    public static RunningMode getRunningMode(){
        return RunningMode.fromValue(appConfigs.getString("running.mode"));
    }

    /**
     * 项目构建版本号
     *
     * @return
     */
    public static String getBuildVersion() {
        return appConfigs.getString("build.version");
    }

}
