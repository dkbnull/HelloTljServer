package cn.wbnull.hellotlj.aop;

import cn.wbnull.hellotlj.model.AppRequest;
import cn.wbnull.hellotlj.util.LoggerUtils;
import cn.wbnull.hellotlj.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 拦截器，签名验签
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Aspect
@Component
public class SignAop {

    @Pointcut("execution(public * cn.wbnull.hellotlj.controller.*.*(..))")
    private void signAop() {

    }

    @Before("signAop()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        AppRequest request = (AppRequest) joinPoint.getArgs()[0];

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = requestAttributes.getRequest();

        LoggerUtils.info(servletRequest.getRemoteAddr(), "前台请求后台", servletRequest.getRequestURI(), logContent(servletRequest.getRequestURI(), request.toString()));
    }

    @AfterReturning(value = "signAop()", returning = "response")
    public JSONObject doAfter(JoinPoint joinPoint, JSONObject response) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = requestAttributes.getRequest();
        String uri = servletRequest.getRequestURI();

        LoggerUtils.info(servletRequest.getRemoteAddr(), "后台返回前台", uri, logContent(servletRequest.getRequestURI(), response.toString()));

        return response;
    }

    private static String logContent(String uri, String params) {
        String apiLog = "log";

        if (uri.endsWith(apiLog)) {
            return StringUtils.substringValue(params, 50, "L") + "...";
        } else {
            return params;
        }
    }
}
