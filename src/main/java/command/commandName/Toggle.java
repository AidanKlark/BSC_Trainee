package command.commandName;

import IO.IErrorPrint;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;

@Slf4j
public class Toggle extends CommandBase {

    @Getter
    private static final String cmd = "toggle";

    @Override
    public void accept(String command) {

        log.info("Запуск класса Toggle");

        int id = CommandId.getId(command);

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            StorageTask.getAllTask().get(id).setStatus(!StorageTask.getAllTask().get(id).isStatus());

        } else {
            errPrint.printError(IErrorPrint.NO_ID);
        }
    }
}
