package work_with_external_data.parsed_objects;

/**
 * Специальный класс, объекты которого хранят данные парсинга в виде чисел
 */

public class ParsedNumber extends ParsedObject {
    Double number;

    public ParsedNumber(Double num) {
        super();
        number = num;
    }

    @Override
    public Double asNumber() {
        return number;
    }
}
