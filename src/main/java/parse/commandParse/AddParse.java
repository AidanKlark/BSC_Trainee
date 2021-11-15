package parse.commandParse;

import lombok.Getter;
import parse.CommandParseImpl;

public class AddParse extends CommandParseImpl {

    @Getter
    private final String cmd = "add";

    @Override
    public String parseArgs(String command) {
        return super.parseArgs(command);
    }

}
