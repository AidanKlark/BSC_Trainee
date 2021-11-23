package command.commandName;

import IO.IErrorPrint;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import storage.TaskStatus;

@Slf4j
public class Edit extends CommandBase {

    @Getter
    private static final String cmd = "edit";

    @Override
    public void accept(String command) {

        int id = CommandId.getId(command);

        log.debug("Редактирование задачи по ID: {}", id);

        TaskStatus newTask = StorageTask.getAllTask().get(id);

        if (newTask != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            newTask.setTask(parse.parseCmdEdit(command));
            newTask.setStatus(false);
        } else {
            errPrint.printError(IErrorPrint.NO_ID);
        }
    }
}
