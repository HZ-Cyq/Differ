package handler.activity;

import com.alibaba.fastjson.JSONObject;
import model.CarnivalActivity;
import model.Player;
import handler.Handler;

public class ActivityRefreshHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        player.clearActivities();
        Integer addId = json.getInteger("addActivityId");
        CarnivalActivity carnivalActivity = new CarnivalActivity();
        carnivalActivity.init(1);
        player.putInActivities(addId, carnivalActivity);
    }
}
