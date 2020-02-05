package cn.wbnull.hellotlj.model.game;

import cn.wbnull.hellotlj.entity.Gametable;
import cn.wbnull.hellotlj.entity.Userinfo;
import cn.wbnull.hellotlj.util.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * 加入游戏接口   后台返回信息
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Data
public class GameJoinAppResponseData {

    private Gametable gametable;
    private List<Userinfo> userinfos;

    public static JSONObject build(Gametable gametable, List<Userinfo> userinfos) {
        GameJoinAppResponseData appResponseData = new GameJoinAppResponseData();
        appResponseData.gametable = gametable;
        appResponseData.userinfos = userinfos;

        return JSONUtils.javaBeanToJSON(appResponseData);
    }
}
