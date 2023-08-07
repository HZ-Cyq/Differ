package handler.player;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Data;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class MultiChangeHandler implements Handler {
    @Override
    public void execute(Player player, JSONObject json) {
        player.diffSetLevel(20);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        player.diffSetList(list);
        Data data = new Data();
        data.setA(10);
        data.setB(20);
        player.diffSetData(data);
    }
}
