package command;

import IO.CommandPrint;
import IO.ErrorPrint;
import IO.ICommandPrint;
import IO.IErrorPrint;
import command.commandName.CommandFactory;
import parse.CommandParser;
import parse.IParser;
import java.util.Map;
import java.util.function.Consumer;

public class CommandStart implements ICommandStart {

    private static final IParser parse = CommandParser.getInstance();
    private static final Map<String, Consumer<String>> getCmd = CommandFactory.getCommand();

    private static ICommandStart commandStart;

    public static ICommandStart getInstance() {
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

