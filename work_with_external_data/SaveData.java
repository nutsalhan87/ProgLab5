package work_with_external_data;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс содержит заголовок метода, который реализует сохранение объекта обобщенного типа (зависит от реализации) в
 * данные определенного формата (тоже зависит от реализации)
 * @param <T>
 */

public interface SaveData<T> {
    public void saveInFile(String path, List<T> data) throws IOException;
}
