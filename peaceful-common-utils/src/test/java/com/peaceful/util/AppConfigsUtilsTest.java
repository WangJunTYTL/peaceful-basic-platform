package com.peaceful.util;

import com.peaceful.common.util.AppConfigs;
import com.peaceful.common.util.Util;
import com.peaceful.common.util.impl.AppConfigsImpl;
import org.junit.Test;

public class AppConfigsUtilsTest {

    @Test
    public void testGetMyAppConfigs() throws Exception {

        AppConfigs myAppConfigs = AppConfigsImpl.getMyAppConfigs("auth.properties");
        Util.report(myAppConfigs.getString("auth.app.id"));


    }
}