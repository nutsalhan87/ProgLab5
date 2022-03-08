package work_with_external_data.parsed_objects;

import java.util.HashMap;
import java.util.Map;

/**
 * Специальный класс, объекты которого хранят данные парсинга в виде словарей
 */

public class ParsedMap extends ParsedObject {
    Map<String, ParsedObject> map;

    public ParsedMap() {
        super();
        map = new HashMap<>();
    }

    public void addObject(String key, ParsedObject obj) {
        map.put(key, obj);
    }

    @Override
    public Map<String, ParsedObject> asMap() {
        return map;
    }
}
