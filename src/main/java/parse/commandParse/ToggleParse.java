package parse.commandParse;

import lombok.Getter;
import parse.CommandParseImpl;

public class ToggleParse extends CommandParseImpl {

    @Getter
    private final String cmd = "toggle";

    @Override
    public int parseId(String command) {
        return super.parseId(command);
    }
}
