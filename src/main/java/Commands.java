import java.io.PrintStream;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Commands {
    private static HashMap<Integer, TaskStatus> idTask = new HashMap<>();
    private static int mapId = 1;
    private final static String NO_ID = "Задачи под таким номером не существует";
    private final static String NO_ARGS = "Нет обязательного аргумента после команды";

    private static PrintStream out(Integer key, TaskStatus taskStatus) {
        return System.out.printf("%d. %s %s\n", key, taskStatus.status ? "[X]" : "[ ]", taskStatus.task);
    }

    private static int findId(String commandId) {
        int id = 0;

        try {
            id = Integer.parseInt(commandId.split(" ") [1]);
        } catch (NumberFormatException nonNumber) {
            System.err.println("Введите число после команды");
        }
        return id;
    }

    public static void add(String task) {

        if (task.isBlank()) {
            System.err.println(NO_ARGS);

        } else {
            idTask.put(mapId++, new TaskStatus(task));
        }
    }

    public static void print(String command) {
        if (command.equals("print")) {
            idTask.entrySet().stream()
                    .filter(a -> !a.getValue().status)
                    .forEach(a -> out(a.getKey(), a.getValue()));
        } else {
            idTask.forEach(Commands::out);
        }
    }

    public static void toggleOrDelete(String command) {
        int id = findId(command);

        if (idTask.get(id) != null || id >= 1 && id <= idTask.size()) {

            if (Pattern.matches("toggle.+", command)) {

                TaskStatus revertStatus = idTask.get(id);
                idTask.get(id).status = !idTask.get(id).status;

            } else if (Pattern.matches("delete.+", command)) {

                idTask.entrySet().removeIf(y -> y.getKey() == id);

            } else {
                System.err.println(NO_ID);
            }
        }
    }


    public static void search(String substring) {
        if (!substring.isBlank()) {
            idTask.entrySet().stream()
                    .filter(a -> a.getValue().task.contains(substring))
                    .forEach(a -> out(a.getKey(), a.getValue()));
        } else {
            System.err.println(NO_ARGS);
        }
    }

    public static void edit(String editTask) {
        int id = findId(editTask);
        TaskStatus newTask = idTask.get(id);

        if (newTask != null && id >= 1 && id <= idTask.size()) {
            newTask.task = editTask.substring(editTask.indexOf(Integer.toString(id)) + 1).trim();
            newTask.status = false;

        } else {
            System.err.println(NO_ID);
        }
    }
}
