package console_application;

/**
 * An exception class that describes the exception required to implement the exit command that exits the program
 */
public class ExitProgramException extends Exception {
    public ExitProgramException() {
        super("Осуществлен выход из программы");
    }
}
