package command;

import storage.TaskStatus;
import java.util.function.Consumer;

public abstract class CommandImpl implements Consumer<String> {
    protected static final String NO_ID = "Задачи под таким номером не существует";
    protected static final String NO_ARGS = "Нет обязательного аргумента после команды";

    protected void out(Integer key, TaskStatus taskStatus) {
        System.out.printf("%d. %s %s\n", key, taskStatus.isStatus() ? "[X]" : "[ ]", taskStatus.getTask());
    }
}
