package model;

import java.util.ArrayList;
import java.util.List;

public class NewbieRankActivity extends BaseActivity {
    private int powerRank;

    private int dungeonRank;

    private List<Integer> gatheredRewards = new ArrayList<>();

    public void init(int id) {
        setId(id);
        setStartTime(System.currentTimeMillis());
        setEndTime(System.currentTimeMillis() + SEVEN_DAYS_MILLIS);
        powerRank = 10000;
        dungeonRank = 10000;
        for (int i = 0; i < 5; i++) {
            gatheredRewards.add(i);
        }
    }

    public int getPowerRank() {
        return powerRank;
    }

    public void setPowerRank(int powerRank) {
        this.powerRank = powerRank;
    }

    public int getDungeonRank() {
        return dungeonRank;
    }

    public void setDungeonRank(int dungeonRank) {
        this.dungeonRank = dungeonRank;
    }

    public List<Integer> getGatheredRewards() {
        return gatheredRewards;
    }

    public void setGatheredRewards(List<Integer> gatheredRewards) {
        this.gatheredRewards = gatheredRewards;
    }
}
