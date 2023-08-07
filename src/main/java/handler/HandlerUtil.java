package handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import handler.activity.*;
import handler.data.DataChangeHandler;
import handler.player.*;
import model.Player;

import java.util.HashMap;

public class HandlerUtil {
    static Player player = new Player();
    static HashMap<Class<?>, Handler> handlerMap = new HashMap<>();

    static {
        handlerMap.put(LevelChangeHandler.class, new LevelChangeHandler());
        handlerMap.put(ListChangeHandler.class, new ListChangeHandler());
        handlerMap.put(SetChangeHandler.class, new SetChangeHandler());
        handlerMap.put(MapChangeHandler.class, new MapChangeHandler());
        handlerMap.put(DataChangeHandler.class, new DataChangeHandler());
        handlerMap.put(MultiChangeHandler.class, new MultiChangeHandler());

        handlerMap.put(MapRefreshHandler.class, new MapRefreshHandler());
        handlerMap.put(ListRefreshHandler.class, new ListRefreshHandler());
        handlerMap.put(SetRefreshHandler.class, new SetRefreshHandler());

        handlerMap.put(LoginHandler.class, new LoginHandler());

        handlerMap.put(ActivityAddHandler.class, new ActivityAddHandler());
        handlerMap.put(ActivityDeleteHandler.class, new ActivityDeleteHandler());
        handlerMap.put(ActivityRefreshHandler.class, new ActivityRefreshHandler());

        handlerMap.put(CarnivalActivityGatherRewardHandler.class, new CarnivalActivityGatherRewardHandler());
        handlerMap.put(CarnivalActivityGatherTaskRewardHandler.class, new CarnivalActivityGatherTaskRewardHandler());
        handlerMap.put(CarnivalActivityGatherTaskRewardHandler2.class, new CarnivalActivityGatherTaskRewardHandler2());
    }

    public static void execute(Class<?> handlerCla, Player player) {
        execute(handlerCla, player, new JSONObject());
    }

    public static void execute(Class<?> handlerCla, Player player, JSONObject json) {
        System.out.println(handlerCla.getSimpleName() + ": " + json.toJSONString());
        // 打印输入参数
        handlerMap.get(handlerCla).execute(player, json);
        String jsonString = JSONObject.toJSONString(player.getLogJson(), SerializerFeature.WriteMapNullValue);
        // 打印diff
        System.out.println(jsonString);
        player.getLogJson().clear();
    }
}
