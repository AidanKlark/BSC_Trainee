package service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {
    private static final String ERROR_NUMBER = "Введите число после команды";

    public static int findId(String commands) {
        log.info("Запуск findId");
        int id = 0;

        try {
            id = Integer.parseInt(commands.split(" ") [1]);
        } catch (NumberFormatException nonNumber) {
            log.error("ПОЛЬЗОВАТЕЛЬ ВВЕЛ НЕ ЧИСЛО: {}", commands);
            System.err.println(ERROR_NUMBER);
        }
        return id;
    }
}
