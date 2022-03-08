package work_with_external_data.parsed_objects;

/**
 * Специальный класс, объекты которого хранят данные парсинга в виде null
 */

public class ParsedNull extends ParsedObject {
    public ParsedNull() {
        super();
        isNull = true;
    }
}
