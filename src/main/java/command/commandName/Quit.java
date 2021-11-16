package command.commandName;

import command.CommandImpl;
import lombok.Getter;

public class Quit extends CommandImpl {

    @Getter
    private final static String cmd = "quit";

    @Override
    public void accept(String command) {
        System.exit(0);
    }
}
