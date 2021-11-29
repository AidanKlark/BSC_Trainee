package com.example.todo.command.commandName;

import com.example.todo.IO.ICommandPrint;
import com.example.todo.IO.IErrorPrint;
import com.example.todo.parse.IParser;
import java.util.function.Consumer;

public abstract class CommandBase implements ICommand {

    protected IParser parse;
    protected IErrorPrint errPrint;
    protected ICommandPrint cmdPrint;

    public CommandBase(IParser parse, ICommandPrint cmdPrint) {
        this.parse = parse;
        this.cmdPrint = cmdPrint;
    }

    public CommandBase(IParser parse, IErrorPrint errPrint) {
        this.parse = parse;
        this.errPrint = errPrint;
    }

    public CommandBase(ICommandPrint cmdPrint) {
        this.cmdPrint = cmdPrint;
    }
}
