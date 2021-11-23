package com.example.todo.command;

import com.example.todo.parse.IParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class CommandStart implements ICommandStart{

    private final Map<String, Consumer<String>> getCmd;
    private final IParser parse;

    @Autowired
    public CommandStart(Map<String, Consumer<String>> getCmd, IParser parse) {
        this.getCmd = getCmd;
        this.parse = parse;
    }

    @Override
    public void start(String inputCmd) {
        Consumer<String> cn = getCmd.get(parse.parseCmd(inputCmd));

        if (cn != null) {
            cn.accept(inputCmd);
        } else {
            System.out.println("Повторите команду");
        }
    }
}
