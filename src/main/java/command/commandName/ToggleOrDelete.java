package command.commandName;

import command.ICommands;
import lombok.extern.slf4j.Slf4j;
import service.Service;
import storage.StorageTask;
import java.util.regex.Pattern;

@Slf4j
public class ToggleOrDelete implements ICommands {
    @Override
    public void execute(String command) {
        log.info("Запуск метода ToggleOrDelete");

        int id = Service.findId(command);

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {

            if (Pattern.matches("toggle .+", command)) {
                log.debug("Изменение статуса задачи по ID: {}", id);

                StorageTask.getAllTask().get(id).setStatus(!StorageTask.getAllTask().get(id).isStatus());

            } else if (Pattern.matches("delete .+", command)) {
                log.debug("Удаление задачи по ID: {}", id);
                StorageTask.removeTask(id);
            }
        } else {
            System.err.println(NO_ID);
        }
    }
}
