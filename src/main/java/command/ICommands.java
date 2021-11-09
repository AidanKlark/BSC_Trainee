package command;

import java.io.PrintStream;
import storage.TaskStatus;

public interface ICommands {
    String NO_ID = "Задачи под таким номером не существует";
    String NO_ARGS = "Нет обязательного аргумента после команды";

    void execute(String command);

    static PrintStream out(Integer key, TaskStatus taskStatus) {
        return System.out.printf("%d. %s %s\n", key, taskStatus.isStatus() ? "[X]" : "[ ]", taskStatus.getTask());
    }
}
