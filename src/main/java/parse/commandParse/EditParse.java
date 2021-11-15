package parse.commandParse;

import lombok.Getter;
import parse.CommandParseImpl;

public class EditParse extends CommandParseImpl {

    @Getter
    private final String cmd = "edit";

    @Override
    public void parseIdArgs(String command) {
        super.parseIdArgs(command);
    }
}
