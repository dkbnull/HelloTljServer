package cn.wbnull.hellotlj.boot;

import cn.wbnull.hellotlj.model.AppResponse;
import cn.wbnull.hellotlj.util.LoggerUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public JSONObject globalExceptionHandler(HttpServletRequest servletRequest, GlobalException e) {
        JSONObject response = AppResponse.error(e.toString());
        LoggerUtils.error(servletRequest.getRemoteAddr(), "后台返回前台", servletRequest.getRequestURI(), response.toString());

        return response;
    }

    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public JSONObject paramExceptionHandler(HttpServletRequest servletRequest, ParamException e) {
        JSONObject response = AppResponse.paramError(e.toString());
        LoggerUtils.error(servletRequest.getRemoteAddr(), "后台返回前台", servletRequest.getRequestURI(), response.toString());

        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject exceptionHandler(HttpServletRequest servletRequest, Exception e) {
        JSONObject response = AppResponse.exception(e.toString());

        LoggerUtils.error(servletRequest.getRemoteAddr(), "后台返回前台", servletRequest.getRequestURI(), response.toString());
        if (printStackTrace(e)) {
            LoggerUtils.error(servletRequest.getRemoteAddr(), "后台返回前台，异常堆栈信息", servletRequest.getRequestURI(), e);
        }

        return response;
    }

    private boolean printStackTrace(Exception e) {
        return !(e instanceof HttpRequestMethodNotSupportedException);
    }
}
