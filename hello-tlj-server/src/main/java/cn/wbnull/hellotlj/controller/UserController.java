package cn.wbnull.hellotlj.controller;

import cn.wbnull.hellotlj.model.AppRequest;
import cn.wbnull.hellotlj.model.user.RegisterAppRequestData;
import cn.wbnull.hellotlj.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@RestController
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public JSONObject userRegister(@RequestBody AppRequest<RegisterAppRequestData> request) throws Exception {
        return userService.userRegister(request.getData());
    }

    @PostMapping(value = "/login")
    public JSONObject userLogin(@RequestBody AppRequest<RegisterAppRequestData> request) throws Exception {
        return userService.userLogin(request.getData());
    }
}
