package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class ListChangeHandler implements Handler {

    @Override
    public void execute(Player player, JSONObject json) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            newList.add(i);
        }
        player.diffSetList(newList);
    }
}
