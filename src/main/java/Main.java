import lombok.extern.slf4j.Slf4j;
import parse.Validator;

@Slf4j
public class Main {

    public static void main(String[] args) {

        log.info("Запуск программы");
        Validator validator = new Validator();
        validator.selection();
    }
}
