package handler;

import com.alibaba.fastjson.JSONObject;
import model.Player;

public interface Handler {
    void execute(Player player, JSONObject json);
}
