package command.commandName;

import command.ICommands;
import storage.StorageTask;

public class Print implements ICommands {

    @Override
    public void execute(String command) {
        if (command.equals("print")) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> ICommands.out(a.getKey(), a.getValue()));
        } else {
            StorageTask.getAllTask().forEach(ICommands::out);
        }
    }
}
