package model;

public class BaseActivity {

    public static long SEVEN_DAYS_MILLIS = 1000L * 60 * 60 * 24 * 7;
    private int id;
    private long startTime;

    private long endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
