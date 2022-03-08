package console_application;

/**
 * Класс-исключение, который описывает исключение, необходимое для реализации команды exit, которая совершает выход из программы
 */
public class ExitProgram extends Exception {
    public ExitProgram() {
        super("Осуществлен выход из программы");
    }
}
