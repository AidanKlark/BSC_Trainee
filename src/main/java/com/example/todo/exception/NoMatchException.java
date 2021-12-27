package com.example.todo.exception;

public class NoMatchException extends RuntimeException {

    public NoMatchException(String message){
        super(message);
    }
}
