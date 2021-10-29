public class TaskStatus {
    private String task;
    private boolean status;

    TaskStatus(String task) {
        this.task = task;
        this.status = false;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTask(String task) {
        this.task = task.trim();
    }

    public String getTask() {
        return task;
    }

    public boolean isStatus() {
        return status;
    }
}
