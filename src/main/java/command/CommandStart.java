package command;

import command.commandName.CommandFactory;

import java.util.function.Consumer;

public class CommandStart implements ICommandStart{

    private final CommandFactory commandFactory;

    public CommandStart(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void start(String inputCmd) {
        Consumer<String> cn = commandFactory.getCmd(inputCmd);
        if (cn != null) {
            cn.accept(inputCmd);
        } else {
            System.out.println("Повторите ввод команды");
        }
    }
}
