package cn.wbnull.hellotlj.controller;

import cn.wbnull.hellotlj.model.AppRequest;
import cn.wbnull.hellotlj.model.game.GameCreateAppRequestData;
import cn.wbnull.hellotlj.model.game.GameJoinAppRequestData;
import cn.wbnull.hellotlj.service.GameService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 游戏接口
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@RestController
@Scope("prototype")
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping(value = "/create")
    public JSONObject gameCreate(@RequestBody AppRequest<GameCreateAppRequestData> request) throws Exception {
        return gameService.gameCreate(request.getData());
    }

    @PostMapping(value = "/join")
    public JSONObject gameJoin(@RequestBody AppRequest<GameJoinAppRequestData> request) throws Exception {
        return gameService.gameJoin(request.getData());
    }

    @PostMapping(value = "/leave")
    public JSONObject gameLeave(@RequestBody AppRequest<GameJoinAppRequestData> request) throws Exception {
        return gameService.gameLeave(request.getData());
    }

    @PostMapping(value = "/info")
    public JSONObject gameInfo(@RequestBody AppRequest<GameJoinAppRequestData> request) throws Exception {
        return gameService.gameInfo(request.getData());
    }

    @PostMapping(value = "/start")
    public JSONObject gameStart(@RequestBody AppRequest<GameJoinAppRequestData> request) throws Exception {
        return gameService.gameStart(request.getData());
    }
}
