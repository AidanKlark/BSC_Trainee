package command;

import parse.CommandParser;
import parse.IParser;
import storage.TaskStatus;
import java.util.function.Consumer;

public abstract class CommandImpl implements Consumer<String> {

    protected static final String NO_ID = "Задачи под таким номером не существует";
    protected static final String NO_ARGS = "Нет обязательного аргумента после команды";
    protected static final String ERR_ID = "Неправильный формат, введите число после команды";

    protected IParser parse = CommandParser.getInstance();

    protected void out(Integer key, TaskStatus taskStatus) {
        System.out.printf("%d. %s %s\n", key, taskStatus.isStatus() ? "[X]" : "[ ]", taskStatus.getTask());
    }
}
