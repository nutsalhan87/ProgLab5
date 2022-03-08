package console_application;

import java.io.IOException;

/**
 * Функциональный интерфейс содержит заголовок метода, реализующего ввод данных с внешнего источника
 */
public interface Input {
    public String nextLine() throws IOException;
}
