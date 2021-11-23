package com.example.todo;

import com.example.todo.IO.IErrorPrint;
import com.example.todo.command.ICommandStart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@SpringBootApplication
public class ToDo implements CommandLineRunner {

    private final ICommandStart cmdStart;
    private final IErrorPrint errPrint;
    private final BufferedReader bufferedReader;

    @Autowired
    public ToDo(ICommandStart cmdStart, IErrorPrint errPrint, BufferedReader bufferedReader) {
        this.cmdStart = cmdStart;
        this.errPrint = errPrint;
        this.bufferedReader = bufferedReader;
    }

    public static void main(String[] args) {

        log.info("Запуск программы");
        SpringApplication.run(ToDo.class, args);
    }

    @Override
    public void run(String... args) {

        while (true) {
            try {
                cmdStart.start(bufferedReader.readLine());
            } catch (IOException e) {
                errPrint.printErrEx("Что-то пошло не так..", e);
            }
        }
    }
}
