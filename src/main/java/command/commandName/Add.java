package command.commandName;

import command.CommandImpl;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import storage.TaskStatus;
import java.util.regex.Pattern;

@Slf4j
public class Add extends CommandImpl {

    @Override
    public void accept(String command) {
        if (Pattern.matches("add.+", command)) {
            String task = command.split(" ", 2)[1];
            log.debug("Добавлена задача: {}", task);

            if (!task.isBlank()) {
                StorageTask.addTask(new TaskStatus(task));
            }
        } else {
            System.out.println(NO_ARGS);
        }
    }
}
