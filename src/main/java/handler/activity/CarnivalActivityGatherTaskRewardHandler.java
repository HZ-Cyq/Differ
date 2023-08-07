package handler.activity;

import com.alibaba.fastjson.JSONObject;
import model.CarnivalActivity;
import model.Player;
import handler.Handler;

public class CarnivalActivityGatherTaskRewardHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Integer activityId = json.getInteger("activityId");
        Integer taskId = json.getInteger("taskId");
        CarnivalActivity carnivalActivity = (CarnivalActivity) player.getActivityMap().get(activityId);
        carnivalActivity.gatherTaskReward(player, taskId);
    }
}
