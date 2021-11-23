package com.example.todo.command.commandName;

import com.example.todo.IO.IErrorPrint;
import com.example.todo.parse.IParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandId {

    private final IErrorPrint errPrint;
    private final IParser parse;

    @Autowired
    public CommandId(IParser parse, IErrorPrint errPrint) {
        this.parse = parse;
        this.errPrint = errPrint;
    }

    protected int getId(String command) {
        int id = 0;
        try {
            id = Integer.parseInt(parse.parseArgs(command));
        } catch (NumberFormatException e) {
            errPrint.printErrEx(IErrorPrint.ERR_ID, e);
        }

        return id;
    }
}
