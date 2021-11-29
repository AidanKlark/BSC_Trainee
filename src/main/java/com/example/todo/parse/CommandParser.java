package com.example.todo.parse;

import org.springframework.stereotype.Service;

@Service
public class CommandParser implements IParser {

    @Override
    public String parseCmdEdit(String command) {
        return command.split(" ", 3) [2];
    }

    @Override
    public String parseArgs(String command) {
        return command.contains(" ") ? command.split(" ", 2) [1] : "";
    }

    @Override
    public String parseCmd(String command) {
        String cmd = "";
        cmd = command.contains(" ") ? command.split(" ") [0] : command;
        return cmd;
    }

    @Override
    public int parseId(String command) {
        try {
            return Integer.parseInt(command.split(" ") [1]);

        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
