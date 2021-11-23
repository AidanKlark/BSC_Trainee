package command;

import command.commandName.CommandFactory;

public class CommandStart implements ICommandStart{

    private final CommandFactory commandFactory;

    public CommandStart(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void start(String inputCmd) {
        commandFactory.getCmd(inputCmd);
    }
}
