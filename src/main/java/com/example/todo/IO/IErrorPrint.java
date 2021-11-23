package com.example.todo.IO;

public interface IErrorPrint {
    String ERR_ID = "Неправильный формат, введите число после команды";
    String NO_ID = "Задачи под таким номером не существует";
    String NO_ARGS = "Нет обязательного аргумента после команды";

    void printError(String message);

    void printErrEx(String message, Throwable throwable);
}
