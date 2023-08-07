import com.alibaba.fastjson.JSONObject;
import handler.activity.*;
import handler.data.DataChangeHandler;
import handler.player.*;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import static handler.HandlerUtil.execute;

public class DemoTest {
    Player player;

    @Before
    public void before() {
        player = new Player();
        player.setId("5_1011");
    }

    /**
     * 修改一个基本类型
     */
    @Test
    public void testChangeLevel() {
        JSONObject json = createJson("newLevel", 10);
        execute(LevelChangeHandler.class, player, json);
    }

    /**
     * 修改引用类型
     * @return
     */
    @Test
    public void testChangeRef() {
        // 修改list
        execute(ListChangeHandler.class, player);
        // 修改set
        execute(SetChangeHandler.class, player);
        // 修改map
        execute(MapChangeHandler.class, player);
        // 修改Data
        JSONObject json = createJson("newA", 10, "newB", 13);
        execute(DataChangeHandler.class, player, json);
    }

    /**
     * 多个字段一起修改
     */
    @Test
    public void testChangeMulti() {
        execute(MultiChangeHandler.class, player);
    }

    /**
     * 一个协议，会刷新集合(将map清空后又添加新的元素 或 既要删除list/set里的某个元素，又要往该list/set中添加新的元素
     * @return
     */
    @Test
    public void testRefreshCollection() {
        // 设置map
        execute(MapChangeHandler.class, player);
        // 刷新map,
        JSONObject jsonObject = createJson("newKey1", 1, "newValue1", "2", "newKey2", 3, "newValue2", "33");
        execute(MapRefreshHandler.class, player, jsonObject);
        // 设置list
        execute(ListChangeHandler.class, player);
        // 刷新list
        JSONObject listRefreshJson = createJson("addId",12 , "removeId", 7 );
        execute(ListRefreshHandler.class, player,  listRefreshJson);
        // 刷新set
        execute(SetChangeHandler.class, player);
        JSONObject setRefreshJson = createJson("addId", 5, "removeId", 2);
        execute(SetRefreshHandler.class, player, setRefreshJson);
    }

    /**
     * 一个具体的例子
     */
    @Test
    public void test() {
        // 登录的时候将玩家所有信息打印
        JSONObject json = createJson("rid", "5_1011");
        execute(LoginHandler.class, player, json);

        // 1、添加或者删除一个活动，将该活动打印出来
        // 添加活动
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("activityId", 1);
        execute(ActivityAddHandler.class, player, jsonObject1);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("activityId", 2);
        execute(ActivityAddHandler.class, player, jsonObject2);
        // 删除活动
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("activityId", 2);
        execute(ActivityDeleteHandler.class, player, jsonObject3);

        // 2、修改某个具体活动里的某个字段，只打印对应字段
        execute(ActivityAddHandler.class, player, jsonObject2);
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("activityId", 1);
        jsonObject4.put("rewardId", 10);
        execute(CarnivalActivityGatherRewardHandler.class,player, jsonObject4);

        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("activityId", 1);
        jsonObject5.put("taskId", 1);
        execute(CarnivalActivityGatherTaskRewardHandler.class, player, jsonObject5);
        // 3、一个协议里可能会同时改变多个字段，将有变化的字段都打印出来
        JSONObject jsonObject6 = new JSONObject();
        jsonObject6.put("activityId", 1);
        jsonObject6.put("taskId", 2);
        execute(CarnivalActivityGatherTaskRewardHandler2.class, player, jsonObject6);

        // 4、重置一个结构，比如活动，先将所有活动删除，然后再接取新的活动
        JSONObject jsonObject7 = new JSONObject();
        jsonObject7.put("addActivityId", 1);
        execute(ActivityRefreshHandler.class, player, jsonObject7);

    }

    JSONObject createJson(Object... params) {
        JSONObject re = new JSONObject();
        for (int i = 0; i < params.length; i += 2) {
            re.put((String) params[i], params[i + 1]);
        }
        return re;
    }
}
