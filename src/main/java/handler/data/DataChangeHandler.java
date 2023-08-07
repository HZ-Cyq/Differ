package handler.data;

import com.alibaba.fastjson.JSONObject;
import handler.Handler;
import model.Data;
import model.Player;

public class DataChangeHandler implements Handler {

    @Override
    public void execute(Player player, JSONObject json) {
        Data data = new Data();
        Integer newA = json.getInteger("newA");
        Integer newB = json.getInteger("newB");
        data.setA(newA);
        data.setB(newB);
        player.diffSetData(data);
    }
}
