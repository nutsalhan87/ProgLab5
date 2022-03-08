package console_application;

/**
 * An exception class that describes an exception that is called if an invalid command is submitted for processing
 */

public class WrongCommand extends Exception {
    public WrongCommand() {
        super("Такой команды нет");
    }

    public WrongCommand(String message) {
        super(message);
    }
}
