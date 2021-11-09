package command.commandName;

import command.CommandImpl;
import storage.StorageTask;
public class Print extends CommandImpl {

    @Override
    public void execute(String command) {

        if (command.equals("print")) {

            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> CommandImpl.out(a.getKey(), a.getValue()));
        } else {
            StorageTask.getAllTask().forEach(CommandImpl::out);
        }
    }
}
