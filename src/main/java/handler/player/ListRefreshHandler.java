package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

public class ListRefreshHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer removeId = json.getInteger("removeId");
        Integer addId = json.getInteger("addId");
        player.getList().remove(removeId);
        player.getList().add(addId);
        player.addListDiff();
    }
}
