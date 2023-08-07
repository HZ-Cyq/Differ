package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

public class MapRefreshHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        // 先将map清除掉
        player.diffClearMap();
        // 再加入新的值
        Integer newKey1 = json.getInteger("newKey1");
        String newValue1 = json.getString("newValue1");
        Integer newKey2 = json.getInteger("newKey2");
        String newValue2 = json.getString("newValue2");
        player.diffPutMap(newKey1, newValue1);
        player.diffPutMap(newKey2, newValue2);
    }
}
