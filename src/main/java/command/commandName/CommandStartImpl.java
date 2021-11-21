package command.commandName;

import IO.CommandPrint;
import IO.ErrorPrint;
import IO.ICommandPrint;
import IO.IErrorPrint;
import command.ICommandStart;
import parse.CommandParser;
import parse.IParser;

import java.util.function.Consumer;

public abstract class CommandStartImpl implements Consumer<String> {

    protected static final IParser parse = CommandParser.getInstance();
    protected static final IErrorPrint errPrint = ErrorPrint.getInstance();
    protected static final ICommandPrint cmdPrint = CommandPrint.getInstance();
}

