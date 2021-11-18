package command;

import IO.CommandPrint;
import IO.ErrorPrint;
import IO.ICommandPrint;
import IO.IErrorPrint;
import parse.CommandParser;
import parse.IParser;
import java.util.function.Consumer;

public abstract class CommandImpl implements Consumer<String> {
    protected static final IErrorPrint errPrint = ErrorPrint.getInstance();
    protected static final ICommandPrint cmdPrint = CommandPrint.getInstance();
    protected static final IParser parse = CommandParser.getInstance();
}
