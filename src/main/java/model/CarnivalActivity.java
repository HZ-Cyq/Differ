package model;

import handler.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarnivalActivity extends BaseActivity {
    private List<Integer> gatheredRewards = new ArrayList<>();

    private HashMap<Integer, String> map = new HashMap<>();

    private HashMap<Integer, Task> tasks = new HashMap<>();

    public void init(int id) {
        setId(1);
        setStartTime(System.currentTimeMillis());
        setEndTime(System.currentTimeMillis() + SEVEN_DAYS_MILLIS);
        for (int i = 0; i < 3; i++) {
            gatheredRewards.add(i);
            map.put(i, String.valueOf(i));
            Task task = new Task();
            task.setTaskId(i);
            task.setArgs(10);
            tasks.put(i, task);
        }
    }

    public void gatherTaskReward(Player player, int taskId) {
        Task task = tasks.get(taskId);
        task.setStatus(2);
        LogUtil.addDiff(player,2, "activities", String.valueOf(getId()), "tasks", String.valueOf(taskId), "status");
    }

    public void gatherReward(Player player, int rewardId) {
        gatheredRewards.add(rewardId);
        LogUtil.addDiff(player, gatheredRewards, "activityMap", String.valueOf(getId()), "gatheredRewards");
    }

    public List<Integer> getGatheredRewards() {
        return gatheredRewards;
    }

    public void setGatheredRewards(List<Integer> gatheredRewards) {
        this.gatheredRewards = gatheredRewards;
    }

    public HashMap<Integer, String> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, String> map) {
        this.map = map;
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<Integer, Task> tasks) {
        this.tasks = tasks;
    }
}
