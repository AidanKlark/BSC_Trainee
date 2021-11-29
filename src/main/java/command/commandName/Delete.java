package command.commandName;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;

@Slf4j
public class Delete extends CommandBase {

    @Getter
    private static final String cmd = "delete";

    @Override
    public void accept(String command) {

        log.info("Запуск класса Delete");

        int id = CommandId.getId(command);

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            log.debug("Удаление задачи по ID: {}", id);
            StorageTask.removeTask(id);
        }
    }
}

