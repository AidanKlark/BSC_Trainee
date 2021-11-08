import lombok.Data;
import java.io.PrintStream;

@Data
public class TaskStatus {
    private String task;
    private boolean status;

    TaskStatus(String task) {
        this.task = task;
        this.status = false;
    }

    public static PrintStream out(Integer key, TaskStatus taskStatus) {
        return System.out.printf("%d. %s %s\n", key, taskStatus.status ? "[X]" : "[ ]", taskStatus.task);
    }
}
