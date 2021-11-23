package command.commandName;

import lombok.Getter;

public class Quit extends CommandBase {

    @Getter
    private static final String cmd = "quit";

    @Override
    public void accept(String command) {
        System.exit(0);
    }
}
