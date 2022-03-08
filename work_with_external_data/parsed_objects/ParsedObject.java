package work_with_external_data.parsed_objects;

import java.util.List;
import java.util.Map;

/**
 * Специальный класс, объекты которого хранят данные парсинга
 */

public class ParsedObject {
    protected boolean isNull;

    public ParsedObject() {
        isNull = false;
    }

    public List<ParsedObject> asList() {
        return null;
    }

    public Map<String, ParsedObject> asMap() {
        return null;
    }

    public String asString() {
        return null;
    }

    public Double asNumber() {
        return null;
    }

    public boolean isNull() {
        return isNull;
    }
}
