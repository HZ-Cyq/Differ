package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

public class LevelChangeHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer newLevel = json.getInteger("newLevel");
        player.diffSetLevel(newLevel);
    }
}
