package parse;

public interface IParser {

    void parseIdArgs(String command);

    void parseArgs(String command);

    void parseId(String command);

    boolean isCmd(String inputCmd, String cmd);
}
