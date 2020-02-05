package cn.wbnull.hellotlj.constant;

/**
 * 中台响应信息，返回码
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS("1000"),

    /**
     * 失败
     */
    FAIL("2000"),

    /**
     * 全局错误，主要为中台业务产生的错误
     */
    ERROR("4000"),

    /**
     * 请求参数错误
     */
    PARAM_ERROR("4001"),

    /**
     * 异常，主要为中台请求三方平台业务产生的异常
     */
    EXCEPTION("5000"),
    ;

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }
}
