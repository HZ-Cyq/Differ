package model;

import handler.LogUtil;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ItemBag {
    private ConcurrentHashMap<Integer, Item> items = new ConcurrentHashMap<>();

    private HashMap<Integer, Integer> fragmentBag = new HashMap<>();

    public void addItem(Player player, int itemId, int num) {
        Item item = new Item();
        item.init(itemId, num);
        items.put(itemId, item);
        LogUtil.addDiff(player, item, "itemBag", "items", String.valueOf(itemId));
    }

    public ConcurrentHashMap<Integer, Item> getItems() {
        return items;
    }

    public void setItems(ConcurrentHashMap<Integer, Item> items) {
        this.items = items;
    }

    public HashMap<Integer, Integer> getFragmentBag() {
        return fragmentBag;
    }

    public void setFragmentBag(HashMap<Integer, Integer> fragmentBag) {
        this.fragmentBag = fragmentBag;
    }
}
