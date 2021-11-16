package parse;

import lombok.Getter;

public class CommandParser implements IParser {

    @Getter
    private String id;

    @Getter
    private String args;

    private static CommandParser commandParser;

    public static CommandParser getInstance() {
        if(commandParser == null) {
            commandParser = new CommandParser();
        }

        return commandParser;
    }

    @Override
    public void parseIdArgs(String command) {
        this.args = command.split(" ") [2];
        parseId(command);
    }

    @Override
    public void parseId(String command) {
            this.id = command.split(" ") [1];
    }

    @Override
    public void parseArgs(String command) {
        this.args = command.split(" ") [1];
    }

    @Override
    public boolean isCmd(String inputCmd, String cmd) {
        return cmd.trim().startsWith(inputCmd);
    }
}

