package command.commandName;

import java.util.Map;
import java.util.function.Consumer;

public class CommandFactory {

    public static Map<String, Consumer<String>> getCommand() {
        return Map.of(Add.getCmd(), new Add(),
                Delete.getCmd(), new Toggle(),
                Edit.getCmd(), new Edit(),
                Print.getCmd(), new Print(),
                Search.getCmd(), new Search(),
                Toggle.getCmd(), new Toggle(),
                Quit.getCmd(), new Quit());
    }





}
