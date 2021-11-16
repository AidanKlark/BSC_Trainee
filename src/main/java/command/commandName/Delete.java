package command.commandName;

import command.CommandImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import java.util.regex.Pattern;

@Slf4j
public class Delete extends CommandImpl {

    @Getter
    private final static String cmd = "delete";

    @Override
    public void accept (String command) {

        if (Pattern.matches("delete.+", command)) {
            log.info("Запуск класса Delete");

            int id = Service.findId(command);

            if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
                log.debug("Удаление задачи по ID: {}", id);
                StorageTask.removeTask(id);
            }
        }
    }
}
