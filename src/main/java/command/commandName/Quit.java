package command.commandName;

import lombok.Getter;

public class Quit extends CommandBase {

    @Getter
    private final static String cmd = "quit";

    @Override
    public void accept(String command) {
        System.exit(0);
    }
}
