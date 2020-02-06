package cn.wbnull.hellotlj.boot;

import cn.wbnull.hellotlj.util.StringUtils;

/**
 * 参数异常
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
public class ParamException extends Exception {

    private static final long serialVersionUID = -2551665137513078722L;

    private String code;
    private String message;

    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
        this.message = message;
    }

    public ParamException(String code, String message) {
        super(code + ": " + message);
        this.code = code;
        this.message = message;
    }

    public ParamException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    public ParamException(Throwable throwable) {
        super(throwable);
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return (StringUtils.isEmpty(code) ? "" : (code + ": ")) + message;
    }
}
