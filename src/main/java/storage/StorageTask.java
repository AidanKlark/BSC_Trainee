package storage;

import java.util.HashMap;
import java.util.Map;

public class StorageTask {
    private static final HashMap<Integer, TaskStatus> idTask = new HashMap<>();
    private static int id = 1;

    public static Map<Integer, TaskStatus> getAllTask() {
        return idTask;
    }

    public static void addTask(TaskStatus taskStatus) {
        idTask.put(id++, taskStatus);
    }

    public static void removeTask(Integer id) {
        idTask.entrySet().removeIf(y -> y.getKey() == id);
    }
}
