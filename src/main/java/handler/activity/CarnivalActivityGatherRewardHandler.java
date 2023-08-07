package handler.activity;

import com.alibaba.fastjson.JSONObject;
import model.CarnivalActivity;
import model.Player;
import handler.Handler;

public class CarnivalActivityGatherRewardHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer activityId = json.getInteger("activityId");
        Integer rewardId = json.getInteger("rewardId");
        CarnivalActivity activity = (CarnivalActivity) player.getActivityMap().get(activityId);
        activity.gatherReward(player, rewardId);
    }
}
