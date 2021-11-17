package parse;

public interface IParser {

    String parseCmdEdit(String command);

    String parseArgs(String command);

    String parseId(String command);

    boolean isCmd(String inputCmd, String cmd);

    String parseCmd(String command);
}
