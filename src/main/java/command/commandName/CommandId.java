package command.commandName;

import IO.ErrorPrint;
import IO.IErrorPrint;
import parse.CommandParser;
import parse.IParser;

public class CommandId {

    private static final IErrorPrint errPrint = ErrorPrint.getInstance();
    private static final IParser parse = CommandParser.getInstance();

    protected static int getId(String command) {
        int id = 0;
        try {
            id = Integer.parseInt(parse.parseId(command));
        } catch (NumberFormatException e) {
            errPrint.printErrEx(IErrorPrint.ERR_ID, e);
        }

        return id;
    }
}
