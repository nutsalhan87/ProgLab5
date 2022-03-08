package console_application;

/**
 * Класс-исключение, который описывает исключение, вызываемое, если на обработку подана неверная команда
 */

public class WrongCommand extends Exception {
    public WrongCommand() {
        super("Такой команды нет");
    }

    public WrongCommand(String message) {
        super(message);
    }
}
