package com.example.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ToDo {

    public static void main(String[] args) {

        log.info("Запуск программы");
        SpringApplication.run(ToDo.class, args);
    }
}
