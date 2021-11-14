package command.commandName;

import command.CommandImpl;
import lombok.extern.slf4j.Slf4j;
import service.Service;
import storage.StorageTask;
import java.util.regex.Pattern;

@Slf4j
public class Toggle extends CommandImpl {

    @Override
    public void execute(String command) {

        if (Pattern.matches("toggle.+", command)) {

            log.info("Запуск класса Toggle");

            int id = Service.findId(command);

            if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {

                StorageTask.getAllTask().get(id).setStatus(!StorageTask.getAllTask().get(id).isStatus());

            } else {
                System.err.println(NO_ID);
            }
        }
    }
}

