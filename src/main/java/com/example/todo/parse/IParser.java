package com.example.todo.parse;

public interface IParser {

    String parseCmdEdit(String command);

    String parseArgs(String command);

    String parseCmd(String command);

    int parseId(String command);
}
