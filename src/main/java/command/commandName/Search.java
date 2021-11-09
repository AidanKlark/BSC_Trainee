package command.commandName;

import command.ICommands;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;

@Slf4j
public class Search implements ICommands {
    @Override
    public void execute(String command) {
        String substring = command.split(" ") [1];
        log.debug("Поиск по ключевому слову: {}", substring);

        if (!substring.isBlank()) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> a.getValue().getTask().contains(substring))
                    .forEach(a -> ICommands.out(a.getKey(), a.getValue()));
        } else {
            System.err.println(NO_ARGS);
        }
    }
}
