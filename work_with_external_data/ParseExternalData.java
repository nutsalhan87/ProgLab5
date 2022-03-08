package work_with_external_data;

import work_with_external_data.parsed_objects.ParsedObject;

import java.io.IOException;

/**
 * Интерфейс содержит заголовок метода, который реализует парсинг из файла данных определенного типа в объект специального
 * класса @see
 */

public interface ParseExternalData {
    public ParsedObject parseFile(String path) throws IOException;
}
