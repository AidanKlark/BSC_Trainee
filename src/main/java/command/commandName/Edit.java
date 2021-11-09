package command.commandName;

import command.CommandImpl;
import lombok.extern.slf4j.Slf4j;
import service.Service;
import storage.StorageTask;
import storage.TaskStatus;
import java.util.regex.Pattern;

@Slf4j
public class Edit extends CommandImpl {

    @Override
    public void execute(String command) {

        if (Pattern.matches("edit.+", command)) {

            int id = Service.findId(command);
            log.debug("Редактирование задачи по ID: {}", id);

            TaskStatus newTask = StorageTask.getAllTask().get(id);

            if (newTask != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
                newTask.setTask(command.split(" ", 3)[2]);
                newTask.setStatus(false);

            } else {
                System.err.println(NO_ID);
            }
        }
    }
}
