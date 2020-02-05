package cn.wbnull.hellotlj.service;

import cn.wbnull.hellotlj.entity.User;
import cn.wbnull.hellotlj.entity.Userinfo;
import cn.wbnull.hellotlj.mapper.UserMapper;
import cn.wbnull.hellotlj.mapper.UserinfoMapper;
import cn.wbnull.hellotlj.model.AppResponse;
import cn.wbnull.hellotlj.model.user.RegisterAppRequestData;
import cn.wbnull.hellotlj.util.JSONUtils;
import cn.wbnull.hellotlj.util.ListUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户接口服务
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Transactional
    public JSONObject userRegister(RegisterAppRequestData appRequestData) {
        if (!ListUtils.isEmpty(userMapper.selectByUsername(appRequestData.getUsername()))) {
            return AppResponse.fail("用户名已存在");
        }

        User user = User.build(appRequestData);
        int result = userMapper.insert(user);
        if (result != 1) {
            return AppResponse.fail("用户注册失败");
        }

        Userinfo userinfo = Userinfo.build(user.getId(), appRequestData);
        result = userinfoMapper.insert(userinfo);

        if (result != 1) {
            return AppResponse.fail("用户注册失败");
        }

        return AppResponse.success(JSONUtils.javaBeanToJSON(userinfo));
    }

    public JSONObject userLogin(RegisterAppRequestData appRequestData) throws Exception {
        List<User> users = userMapper.selectByUsername(appRequestData.getUsername());
        if (ListUtils.isEmpty(users)) {
            return AppResponse.fail("用户不存在");
        }

        User user = users.get(0);
        if (!user.getPassword().equals(appRequestData.getPassword())) {
            return AppResponse.fail("用户名或密码错误");
        }

        Userinfo userinfo = userinfoMapper.selectById(user.getId());
        return AppResponse.success(JSONUtils.javaBeanToJSON(userinfo));
    }
}
