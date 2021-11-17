package parse;

public class CommandParser implements IParser {

    private static CommandParser commandParser;

    public static CommandParser getInstance() {
        if(commandParser == null) {
            commandParser = new CommandParser();
        }

        return commandParser;
    }

    @Override
    public String parseCmdEdit(String command) {
        return command.split(" ") [2];
    }

    @Override
    public String parseId(String command) {
            return command.split(" ") [1];
    }

    @Override
    public String parseArgs(String command) {
        return command.split(" ") [1];
    }

    @Override
    public String parseCmd(String command) {
        String cmd = "";

        if (!command.equals(cmd)) {
            cmd = command.contains(" ") ? command.split(" ") [0] : command;
        } else {
            System.out.println("Команда не введена");
        }

        return cmd;
    }
}

