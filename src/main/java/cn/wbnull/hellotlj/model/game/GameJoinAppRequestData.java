package cn.wbnull.hellotlj.model.game;

import lombok.Data;

/**
 * 加入游戏接口   前台请求信息
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Data
public class GameJoinAppRequestData {

    private String tableId;
    private String userId;
}
