package command.commandName;

import parse.CommandParser;
import parse.IParser;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CommandFactory {

    private final IParser parse = CommandParser.getInstance();
    Map<String, Consumer<String>> cmdFactory;

    public CommandFactory() {
        cmdFactory = new HashMap<>();

        cmdFactory.put(Add.getCmd(), new Add());
        cmdFactory.put(Delete.getCmd(), new Delete());
        cmdFactory.put(Edit.getCmd(), new Edit());
        cmdFactory.put(Print.getCmd(), new Print());
        cmdFactory.put(Search.getCmd(), new Search());
        cmdFactory.put(Toggle.getCmd(), new Toggle());
        cmdFactory.put(Quit.getCmd(), new Quit());
    }

    public Consumer<String> getCmd(String cmd) {
        return  cmdFactory.get(parse.parseCmd(cmd));
    }
}
