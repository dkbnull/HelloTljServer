package cn.wbnull.hellotlj.model.game;

import lombok.Data;

import java.util.List;

/**
 * 开始游戏接口   后台返回信息
 *
 * @author dukunbiao(null)  2020-02-07
 * https://github.com/dkbnull/HelloTljServer
 */
@Data
public class GameStartAppResponseData {

    private String userId;
    private List<String> pokers;

    public static GameStartAppResponseData build(String userId, List<String> pokers) {
        GameStartAppResponseData appResponseData = new GameStartAppResponseData();
        appResponseData.userId = userId;
        appResponseData.pokers = pokers;

        return appResponseData;
    }
}
