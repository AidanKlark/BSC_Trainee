package parse;

public interface IParser {

    String parseCmdEdit(String command);

    String parseArgs(String command);

    String parseCmd(String command);
}