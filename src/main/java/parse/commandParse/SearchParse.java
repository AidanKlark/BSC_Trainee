package parse.commandParse;

import lombok.Getter;
import parse.CommandParseImpl;

public class SearchParse extends CommandParseImpl {

    @Getter
    private final String cmd = "search";

    @Override
    public String parseArgs(String command) {
        return super.parseArgs(command);
    }
}
