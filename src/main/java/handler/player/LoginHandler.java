package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import handler.LogUtil;
import model.Player;

public class LoginHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        // 登录的时候将玩家的所有信息打印出来
        LogUtil.addDiff(player, player);
    }
}
