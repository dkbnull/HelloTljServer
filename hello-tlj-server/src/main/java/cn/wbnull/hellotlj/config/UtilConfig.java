package cn.wbnull.hellotlj.config;

import cn.wbnull.hellotlj.util.StringUtils;

/**
 * Logger 工具类
 *
 * @author dukunbiao(null)  2018-12-17
 * https://github.com/dkbnull/HelloUtil
 */
public class UtilConfig {

    private static String logLevel;

    private static void init() {
        logLevel = AipConfig.getLogLevel();
    }

    public static String getLogLevel() {
        if (StringUtils.isEmpty(logLevel)) {
            init();
        }

        return logLevel;
    }
}
