package parse;

import lombok.Getter;

abstract public class CommandParseImpl implements ParseLine {

    @Getter
    protected int id;

    @Getter
    protected String args;

    @Getter
    protected String cmd;

    @Override
    public void parseIdArgs(String command) {
        this.args = command.split(" ") [2];
        this.id = Integer.parseInt(command.split(" ") [1]);
    }

    public boolean isCmd(String inputCmd, String cmd) {
        return cmd.startsWith(inputCmd);
    }
}
