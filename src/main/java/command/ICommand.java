package command;

public interface ICommand {
    String NO_ID = "Задачи под таким номером не существует";
    String NO_ARGS = "Нет обязательного аргумента после команды";

    void execute(String command);
}
