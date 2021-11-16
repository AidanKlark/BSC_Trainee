package command.commandName;

import command.CommandImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import storage.StorageTask;
import java.util.regex.Pattern;

@Slf4j
public class Search extends CommandImpl {

    @Getter
    private final static String cmd = "search";

    @Override
    public void accept (String command) {

        if (Pattern.matches("search.+", command)) {

            String substring = command.split(" ")[1];
            log.debug("Поиск по ключевому слову: {}", substring);

            if (!substring.isBlank()) {
                StorageTask.getAllTask().entrySet().stream()
                        .filter(a -> a.getValue().getTask().contains(substring))
                        .forEach(a -> out(a.getKey(), a.getValue()));
            } else {
                System.err.println(NO_ARGS);
            }
        }
    }
}
