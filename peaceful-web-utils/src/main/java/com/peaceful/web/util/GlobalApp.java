package com.peaceful.web.util;

import com.peaceful.common.util.AppConfigs;
import com.peaceful.common.util.Util;
import com.peaceful.common.util.impl.AppConfigsImpl;

/**
 * Date 14/10/28.
 * Author WangJun
 * Email wangjuntytl@163.com
 * <p/>
 * <h3>web app 全局配置信息</h3>
 */
public class GlobalApp {

    private static AppConfigs appConfigs = AppConfigsImpl.getMyAppConfigs("application.properties");

    /**
     * 项目是否在dev环境运行
     *
     * @return
     */
    public static boolean isDev() {
        String mode = appConfigs.getString("dev.mode");
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
        String mode = appConfigs.getString("dev.mode");
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
        String mode = appConfigs.getString("dev.mode");
        if (mode.equals("product"))
            return true;
        else
            return false;
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
