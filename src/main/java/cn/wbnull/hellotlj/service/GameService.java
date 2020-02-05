package cn.wbnull.hellotlj.service;

import cn.wbnull.hellotlj.entity.Gametable;
import cn.wbnull.hellotlj.entity.Userinfo;
import cn.wbnull.hellotlj.mapper.GametableMapper;
import cn.wbnull.hellotlj.mapper.UserinfoMapper;
import cn.wbnull.hellotlj.model.AppResponse;
import cn.wbnull.hellotlj.model.game.GameCreateAppRequestData;
import cn.wbnull.hellotlj.model.game.GameJoinAppRequestData;
import cn.wbnull.hellotlj.model.game.GameJoinAppResponseData;
import cn.wbnull.hellotlj.util.ListUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏接口服务
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Service
public class GameService {

    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private GametableMapper gametableMapper;

    @Transactional
    public JSONObject gameCreate(GameCreateAppRequestData appRequestData) {
        return AppResponse.fail();
    }

    public JSONObject gameJoin(GameJoinAppRequestData appRequestData) {
        //如果用户已加入该房间，先删除该用户
        QueryWrapper<Gametable> wrapperUser = new QueryWrapper<>();
        wrapperUser.eq("tableId", appRequestData.getTableId());
        wrapperUser.eq("userId", appRequestData.getUserId());
        gametableMapper.delete(wrapperUser);

        //查询所有加入该房间的用户，如果没有用户加入则第一个加入的视为房主
        QueryWrapper<Gametable> wrapperTable = new QueryWrapper<>();
        wrapperTable.eq("tableId", appRequestData.getTableId());
        List<Gametable> gametables = gametableMapper.selectList(wrapperTable);
        String owner = "0";
        if (ListUtils.isEmpty(gametables)) {
            owner = "1";
        }
        gametableMapper.insert(Gametable.build(appRequestData, owner));

        return gameInfo(appRequestData);
    }

    public JSONObject gameLeave(GameJoinAppRequestData appRequestData) {
        QueryWrapper<Gametable> wrapperUser = new QueryWrapper<>();
        wrapperUser.eq("tableId", appRequestData.getTableId());
        wrapperUser.eq("userId", appRequestData.getUserId());

        gametableMapper.delete(wrapperUser);
        return AppResponse.success();
    }

    public JSONObject gameInfo(GameJoinAppRequestData appRequestData) {
        QueryWrapper<Gametable> wrapperTable = new QueryWrapper<>();
        wrapperTable.eq("tableId", appRequestData.getTableId());
        List<Gametable> gametables = gametableMapper.selectList(wrapperTable);

        Gametable gametable = null;
        List<Userinfo> userinfos = new ArrayList<>();
        for (Gametable gametableTemp : gametables) {
            //当前用户详细信息无需再次查询
            if (gametableTemp.getUserId().equals(appRequestData.getUserId())) {
                gametable = gametableTemp;
                continue;
            }

            Userinfo user = userinfoMapper.selectById(gametableTemp.getUserId());
            userinfos.add(user);
        }

        return AppResponse.success(GameJoinAppResponseData.build(gametable, userinfos));
    }
}
