package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

import java.util.HashSet;
import java.util.Set;

public class SetChangeHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(i);
        }
        player.diffSetSet(set);
    }
}
