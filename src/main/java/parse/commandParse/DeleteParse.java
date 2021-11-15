package parse.commandParse;

import lombok.Getter;
import parse.CommandParseImpl;

public class DeleteParse extends CommandParseImpl {

    @Getter
    private final String cmd = "delete";

    @Override
    public void parseIdArgs(String command) {
        super.parseIdArgs(command);
    }
}
