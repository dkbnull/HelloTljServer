package cn.wbnull.hellotlj.model;

import cn.wbnull.hellotlj.util.JSONUtils;
import lombok.Data;

/**
 * 前台请求信息
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Data
public class AppRequest<T> {

    /**
     * 业务数据
     */
    private T data;

    /**
     * 签名
     */
    private String sign;

    /**
     * 时间戳
     */
    private String timestamp;

    @Override
    public String toString() {
        return JSONUtils.javaBeanToJSON(this).toString();
    }
}
