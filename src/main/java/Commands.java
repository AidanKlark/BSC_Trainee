import java.util.HashMap;

public class Commands {
    private boolean status;
    private String task;
    private static HashMap<Integer, Commands> statusId = new HashMap<>();
    private static int id = 1;
    private final static String NO_ID = "Задачи под таким номером не существует";
    private final static String NO_ARGS = "Нет обязательного аргумента после команды";

    Commands(String task) {
        statusId.put(id++, this);
        this.task = task;
        this.status = false;
    }

    private static void out(int i) {
        System.out.printf("%d. %s %s\n", i, statusId.get(i).status ? "[X]" : "[ ]", statusId.get(i).task);
    }

    public static void add(String task) {

        if (task.isBlank()) {
            System.err.println(NO_ARGS);

        } else {
            new Commands(task);
        }
    }

    public static void print(String commands) {
        for (int i : statusId.keySet()) {
            if (commands.equals("print") && !statusId.get(i).status || commands.equals("print all")) {
                out(i);
            }
        }
    }

    public static void toggle(int id) {
        Commands revertStatus = statusId.get(id);
        if (revertStatus != null || id >= 1 && id < statusId.size()) {
            statusId.get(id).status = !statusId.get(id).status;
        } else {
            System.err.println(NO_ID);
        }
    }

    public static void delete(int id) {
        if (id >= 1 && id < statusId.size()) {
            statusId.entrySet().removeIf(y -> (y.getKey() == id));
        } else {
            System.err.println(NO_ID);
        }
    }

    public static void search(String substring) {
        if (!substring.isBlank()) {
            for (int i : statusId.keySet()) {
                if (statusId.get(i).task.contains(substring)) {
                    out(i);
                }
            }
        } else {
            System.err.println(NO_ARGS);
        }
    }

    public static void edit(String editTask) {
        int id = Integer.parseInt(editTask.split(" ") [1]);
        Commands newTask = statusId.get(id);

        if (id >= 1 && id < statusId.size()) {
            newTask.task = editTask.substring(editTask.indexOf(Integer.toString(id)) + 1).trim();
            newTask.status = false;

        } else {
            System.err.println(NO_ID);
        }
    }
}
