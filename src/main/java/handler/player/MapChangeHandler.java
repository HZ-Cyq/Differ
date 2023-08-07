package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

import java.util.HashMap;

public class MapChangeHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        HashMap<Integer, String> newMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            newMap.put(i, "value" + i);
        }
        player.diffSetMap(newMap);
    }
}
