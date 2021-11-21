package command.commandName;

import lombok.Getter;
import storage.StorageTask;

public class Print extends CommandStartImpl {

    @Getter
    private final static String cmd = "print";

    private final static String ALL = "print all";

    @Override
    public void accept(String command) {

        if (!command.equals(ALL)) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> cmdPrint.out(a.getKey(), a.getValue()));
        } else {
            StorageTask.getAllTask().forEach(cmdPrint::out);
        }
    }
}

