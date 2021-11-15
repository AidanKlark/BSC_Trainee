package parse.commandParse;

import lombok.Getter;
import parse.CommandParseImpl;

public class PrintParse extends CommandParseImpl {

    @Getter
    private final String cmd = "print";

    @Getter
    String all;

    @Override
    public String parseArgs(String command) {
        all = command.split(" ") [1];
        return all;
    }
}
