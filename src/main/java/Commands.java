import java.util.regex.Pattern;

public class Commands {
    private static final String NO_ID = "Задачи под таким номером не существует";
    private static final String NO_ARGS = "Нет обязательного аргумента после команды";

    public static void add(String command) {
        String task = command.split(" ", 2) [1];

        if (!task.isBlank()) {
            StorageTask.addTask(new TaskStatus(task));
        } else {
            System.out.println(NO_ARGS);
        }
    }

    public static void print(String command) {
        if (command.equals("print")) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> TaskStatus.out(a.getKey(), a.getValue()));
        } else {
            StorageTask.getAllTask().forEach(TaskStatus::out);
        }
    }

    public static void toggleOrDelete(String command) {
        int id = Service.findId(command);

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {

            if (Pattern.matches("toggle .+", command)) {

                StorageTask.getAllTask().get(id).setStatus(!StorageTask.getAllTask().get(id).isStatus());

            } else if (Pattern.matches("delete .+", command)) {
                StorageTask.removeTask(id);
            }
        } else {
            System.err.println(NO_ID);
        }
    }

    public static void search(String command) {
        String substring = command.split(" ") [1];

        if (!substring.isBlank()) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> a.getValue().getTask().contains(substring))
                    .forEach(a -> TaskStatus.out(a.getKey(), a.getValue()));
        } else {
            System.err.println(NO_ARGS);
        }
    }

    public static void edit(String command) {
        int id = Service.findId(command);

        TaskStatus newTask = StorageTask.getAllTask().get(id);

        if (newTask != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            newTask.setTask(command.split(" ", 3) [2]);
            newTask.setStatus(false);

        } else {
            System.err.println(NO_ID);
        }
    }
}
