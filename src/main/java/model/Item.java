package model;

public class Item {
    private int itemId;

    private int templateId;

    private int num;

    public void init(int itemId, int num) {
        this.itemId = itemId;
        this.num = num;
    }
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
