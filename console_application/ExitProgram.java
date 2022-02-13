package console_application;

public class ExitProgram extends Exception{
    public ExitProgram()
    {
        super("Осуществлен выход из программы");
    }
}
