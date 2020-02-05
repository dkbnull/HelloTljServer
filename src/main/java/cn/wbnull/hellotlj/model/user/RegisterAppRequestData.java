package cn.wbnull.hellotlj.model.user;

import lombok.Data;

/**
 * 用户注册接口   前台请求信息
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Data
public class RegisterAppRequestData {

    private String nickname;
    private String username;
    private String password;
}
