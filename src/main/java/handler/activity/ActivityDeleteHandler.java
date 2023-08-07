package handler.activity;

import com.alibaba.fastjson.JSONObject;
import model.Player;
import handler.Handler;

public class ActivityDeleteHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer activityId = json.getInteger("activityId");
        player.removeFromActivities(activityId);
    }
}
