package command.commandName;

import command.CommandImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import storage.TaskStatus;

@Slf4j
public class Add extends CommandImpl {

    @Getter
    private final static String cmd = "add";

    @Override
    public void accept(String command) {

            String task = parse.parseArgs(command);
            log.debug("Добавлена задача: {}", task);

            if (!task.isBlank()) {
                StorageTask.addTask(new TaskStatus(task));
            } else {
            System.out.println(NO_ARGS);
        }
    }
}
