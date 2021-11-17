package command.commandName;

import command.CommandImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;

@Slf4j
public class Toggle extends CommandImpl {

    @Getter
    private final static String cmd = "toggle";

    @Override
    public void accept (String command) {

        log.info("Запуск класса Toggle");

        int id = 0;

        try {
            id = Integer.parseInt(parse.parseId(command));
        } catch (NumberFormatException e) {
            System.err.println(ERR_ID);
        }

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            StorageTask.getAllTask().get(id).setStatus(!StorageTask.getAllTask().get(id).isStatus());

        } else {
            System.err.println(NO_ID);
        }
    }
}
