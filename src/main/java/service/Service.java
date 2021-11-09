package service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {
    private static final String ERROR_NUMBER = "Введите число после команды";

    public static int findId(String command) {
        log.info("Запуск findId");
        int id = 0;

        try {
            id = Integer.parseInt(command.split(" ") [1]);
        } catch (NumberFormatException nonNumber) {
            log.error("ПОЛЬЗОВАТЕЛЬ ВВЕЛ НЕ ЧИСЛО: {}", command);
            System.err.println(ERROR_NUMBER);
        }
        return id;
    }

    public static String findCommandType(String command) {
        String commandType = command.replaceAll(" .*", "");

        return commandType;
    }
}
