package IO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorPrint implements IErrorPrint{

    private static ErrorPrint errorPrint;

    public static IErrorPrint getInstance() {
        if(errorPrint == null) {
            errorPrint = new ErrorPrint();
        }

        return errorPrint;
    }

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
