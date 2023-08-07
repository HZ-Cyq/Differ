package model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import handler.LogUtil;
import java.util.*;

public class Player {
    private String id;

    private int level;

    private List<Integer> list = new ArrayList<>();

    private Set<Integer> set = new HashSet<>();

    private Map<Integer, String> map = new HashMap<>();

    private Data data = new Data();

    private Map<Integer, BaseActivity> activityMap = new HashMap<>();

    private ItemBag itemBag = new ItemBag();

    @JSONField(serialize = false)
    private JSONObject logJson = new JSONObject();

    private static final JSONObject EMPTY_JSON = new JSONObject();
    private static final String EMPTY_JSON_STR = EMPTY_JSON.toJSONString();

    public void diffSetLevel(int newLevel) {
        this.level = newLevel;
        LogUtil.addDiff(this, newLevel, "level");
    }

    public void diffSetList(List<Integer> newList) {
        this.list = newList;
        LogUtil.addDiff(this, this.list, "list");
    }

    public void addListDiff() {
        LogUtil.addDiff(this, this.list, "list");
    }

    public void diffSetSet(Set<Integer> newSet) {
        this.set = newSet;
        LogUtil.addDiff(this, newSet, "set");
    }

    public void addSetDiff() {
        LogUtil.addDiff(this, set, "set");
    }
    public void diffSetMap(Map<Integer, String> newMap) {
        this.map = newMap;
        LogUtil.addDiff(this, newMap, "map");
    }

    public void diffPutMap(int key, String value) {
        this.map.put(key, value);
        LogUtil.addDiff(this, value, "map", String.valueOf(key));
    }

    public void diffClearMap() {
        Set<Integer> keySet = new HashSet<>(map.keySet());
        this.map.clear();
        for (Integer key : keySet) {
            LogUtil.addDiff(this, EMPTY_JSON_STR, "map", String.valueOf(key));
        }
    }

    public void diffSetData(Data newData) {
        this.data = newData;
        LogUtil.addDiff(this, newData, "data");
    }
    public void putInActivities(int id, BaseActivity activity) {
        activityMap.put(id, activity);
        LogUtil.addDiff(this, activity, "activityMap", String.valueOf(id));
    }

    public void removeFromActivities(int id) {
        activityMap.remove(id);
        LogUtil.addDiff(this, EMPTY_JSON_STR, "activityMap", String.valueOf(id));
    }


    public void clearActivities() {
        Set<Integer> keys = new HashSet<>(activityMap.keySet());
        activityMap.clear();
        for (Integer key : keys) {
            LogUtil.addDiff(this, EMPTY_JSON_STR, "activityMap", String.valueOf(key));
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Map<Integer, BaseActivity> getActivityMap() {
        return activityMap;
    }

    public void setActivityMap(Map<Integer, BaseActivity> activityMap) {
        this.activityMap = activityMap;
    }

    public ItemBag getItemBag() {
        return itemBag;
    }

    public void setItemBag(ItemBag itemBag) {
        this.itemBag = itemBag;
    }

    public JSONObject getLogJson() {
        return logJson;
    }

    public void setLogJson(JSONObject logJson) {
        this.logJson = logJson;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
