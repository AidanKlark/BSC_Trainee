package command;

import command.commandName.CommandFactory;
import lombok.Getter;
import parse.CommandParser;
import parse.IParser;

import java.util.Map;
import java.util.function.Consumer;

public class CommandStart implements ICommandStart{



    private final Map<String, Consumer<String>> getCommand = CommandFactory.getCommand();

    @Override
    public void start(String inputCmd) {

        getCommand.get(cmd).accept(inputCmd);

        //todo
    }
}

