package command.commandName;

import command.ICommands;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import storage.TaskStatus;

@Slf4j
public class Add implements ICommands {

    @Override
    public void execute(String command) {
        String task = command.split(" ", 2) [1];
        log.debug("Добавлена задача: {}", task);

        if (!task.isBlank()) {
            StorageTask.addTask(new TaskStatus(task));
        } else {
            System.out.println(NO_ARGS);
        }
    }
}
