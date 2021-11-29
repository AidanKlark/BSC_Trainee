package command.commandName;

import IO.IErrorPrint;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import storage.TaskStatus;

@Slf4j
public class Add extends CommandBase {

    @Getter
    private static final String cmd = "add";

    @Override
    public void accept(String command) {

            String task = parse.parseArgs(command);
            log.debug("Добавлена задача: {}", task);

            if (!task.isBlank()) {
                StorageTask.addTask(new TaskStatus(task));
            } else {
            errPrint.printError(IErrorPrint.NO_ARGS);
        }
    }
}
