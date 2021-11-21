package command.commandName;

import IO.IErrorPrint;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;

@Slf4j
public class Search extends CommandBase {

    @Getter
    private final static String cmd = "search";

    @Override
    public void accept(String command) {

        String substring = parse.parseArgs(command);
        log.debug("Поиск по ключевому слову: {}", substring);

        if (!substring.isBlank()) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> a.getValue().getTask().contains(substring))
                    .forEach(a -> cmdPrint.out(a.getKey(), a.getValue()));
        } else {
            errPrint.printError(IErrorPrint.NO_ARGS);
        }
    }
}

