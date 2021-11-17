package command.commandName;

import command.CommandImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import storage.TaskStatus;

@Slf4j
public class Edit extends CommandImpl {

    @Getter
    private final static String cmd = "edit";

    @Override
    public void accept (String command) {

        int id = 0;
        try {
            id = Integer.parseInt(parse.parseId(command));
        } catch (NumberFormatException e) {
            System.err.println(ERR_ID);
        }

        log.debug("Редактирование задачи по ID: {}", id);

        TaskStatus newTask = StorageTask.getAllTask().get(id);

        if (newTask != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            newTask.setTask(parse.parseCmdEdit(command));
            newTask.setStatus(false);
        } else {
            System.err.println(NO_ID);
        }
    }
}
