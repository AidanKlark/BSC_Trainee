package command.commandName;

import command.CommandImpl;
import storage.StorageTask;
public class Print extends CommandImpl {

    @Override
    public void execute(String command) {

        switch (command) {
            case "print" -> StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> super.out(a.getKey(), a.getValue()));

            case "print all" -> StorageTask.getAllTask().forEach(super::out);

            default -> System.out.println("Неверная команда, повторите ввод");
        }
    }
}
