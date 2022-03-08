package console_application;

/**
 * An exception class that describes the exception required to implement the exit command that exits the program
 */
public class ExitProgram extends Exception {
    public ExitProgram() {
        super("Осуществлен выход из программы");
    }
}
