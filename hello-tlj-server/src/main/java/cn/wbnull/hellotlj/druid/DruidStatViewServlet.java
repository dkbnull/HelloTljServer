package cn.wbnull.hellotlj.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * druid 管理页面配置
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value = "127.0.0.1"),
        @WebInitParam(name = "loginUsername", value = "admin"),
        @WebInitParam(name = "loginPassword", value = "admin"),
        @WebInitParam(name = "resetEnable", value = "true")
})
public class DruidStatViewServlet extends StatViewServlet implements Servlet {

    private static final long serialVersionUID = -3700771770088388046L;
}
