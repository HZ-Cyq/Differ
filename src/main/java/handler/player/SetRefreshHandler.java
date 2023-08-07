package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

public class SetRefreshHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer addId = json.getInteger("addId");
        Integer removeId = json.getInteger("removeId");
        player.getSet().remove(removeId);
        player.getSet().add(addId);
        player.addSetDiff();
    }
}
