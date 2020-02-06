package cn.wbnull.hellotlj.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * application.yml
 *
 * @author dukunbiao(null)  2020-02-04
 * https://github.com/dkbnull/HelloTljServer
 */
@Component
@PropertySource(value = "application.yml", encoding = "UTF-8")
@ConfigurationProperties(prefix = "aip")
public class AipConfig {

    private static String logLevel;
    private static String isVerifySign;

    public static boolean isVerifySign() {
        return "1".equals(isVerifySign);
    }

    public static String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        AipConfig.logLevel = logLevel;
    }

    public static String getIsVerifySign() {
        return isVerifySign;
    }

    public void setIsVerifySign(String isVerifySign) {
        AipConfig.isVerifySign = isVerifySign;
    }
}
