package command.commandName;

import command.ICommands;
import lombok.extern.slf4j.Slf4j;
import service.Service;
import storage.StorageTask;
import storage.TaskStatus;

@Slf4j
public class Edit implements ICommands {

    @Override
    public void execute(String command) {
        int id = Service.findId(command);
        log.debug("Редактирование задачи по ID: {}", id);

        TaskStatus newTask = StorageTask.getAllTask().get(id);

        if (newTask != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            newTask.setTask(command.split(" ", 3) [2]);
            newTask.setStatus(false);

        } else {
            System.err.println(NO_ID);
        }
    }
}
