package console_application;

public class WrongCommand extends Exception {
    public WrongCommand()
    {
        super("Такой команды нет");
    }

    public WrongCommand(String message)
    {
        super(message);
    }
}
