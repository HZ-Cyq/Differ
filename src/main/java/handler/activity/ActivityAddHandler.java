package handler.activity;

import com.alibaba.fastjson.JSONObject;
import model.CarnivalActivity;
import model.NewbieRankActivity;
import model.Player;
import handler.Handler;

public class ActivityAddHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer activityId = json.getInteger("activityId");
        if(activityId == 1) {
            CarnivalActivity carnivalActivity = new CarnivalActivity();
            carnivalActivity.init(1);
            player.putInActivities(activityId, carnivalActivity);
        } else if(activityId == 2) {
            NewbieRankActivity newbieRankActivity = new NewbieRankActivity();
            newbieRankActivity.init(2);
            player.putInActivities(activityId, newbieRankActivity);
        }
    }
}
