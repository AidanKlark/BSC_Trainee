package command;

import command.commandName.CommandFactory;
import command.commandName.CommandStartImpl;
import parse.CommandParser;
import parse.IParser;

import java.util.Map;
import java.util.function.Consumer;

public class CommandStart implements ICommandStart{

    protected static final IParser parse = CommandParser.getInstance();
    private static final Map<String, Consumer<String>> getCmd = CommandFactory.getCommand();

    private static CommandStart commandStart;

    public static CommandStart getInstance() {
        if(commandStart == null) {
            commandStart = new CommandStart();
        }

        return commandStart;
    }

    @Override
    public void start(String inputCmd) {
        if (getCmd.get(parse.parseCmd(inputCmd)) != null) {
            getCmd.get(parse.parseCmd(inputCmd)).accept(inputCmd);
        } else {
            System.out.println("Повторите команду");
        }
    }
}
