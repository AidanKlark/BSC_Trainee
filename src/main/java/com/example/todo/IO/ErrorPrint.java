package com.example.todo.IO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorPrint implements IErrorPrint{

    @Override
    public void printError(String message) {
        log.error(message);
        System.err.println(message);
    }

    @Override
    public void printErrEx(String message, Throwable throwable) {
        log.error(message);
        System.err.println(message);
    }
}
