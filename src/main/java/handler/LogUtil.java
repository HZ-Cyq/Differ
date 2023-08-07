package handler;

import com.alibaba.fastjson.JSONObject;
import model.Player;

public class LogUtil {
    public static void addDiff(Player player, Object newValue, String... levels) {
        JSONObject parent = findParent(player, levels);
        // 没有层级，说明打印的是整个Player信息。
        if (levels.length == 0) {
            player.getLogJson().put(player.getId(), newValue);
        } else {
            parent.put(levels[levels.length - 1], newValue);
        }
    }

    private static JSONObject findParent(Player player, String... levels) {
        player.getLogJson().putIfAbsent(player.getId(), new JSONObject());
        JSONObject json = player.getLogJson().getJSONObject(player.getId());
        for(int i = 0; i < levels.length - 1; i++) {
            String level = levels[i];
            if(json.containsKey(level)) {
                json = json.getJSONObject(level);
            } else {
                JSONObject newJson = new JSONObject();
                json.put(level, newJson);
                json = newJson;
            }
        }
        return json;
    }
}
