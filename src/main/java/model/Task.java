package model;

public class Task {
    private int taskId;

    private int args;

    private int status;
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getArgs() {
        return args;
    }

    public void setArgs(int args) {
        this.args = args;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
