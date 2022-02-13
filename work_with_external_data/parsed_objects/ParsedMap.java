package work_with_external_data.parsed_objects;

import java.util.HashMap;
import java.util.Map;

public class ParsedMap extends ParsedObject
{
    Map<ParsedString, ParsedObject> map;

    public ParsedMap()
    {
        super();
        map = new HashMap<>();
    }

    public void addObj(ParsedString key, ParsedObject obj)
    {
        map.put(key, obj);
    }

    @Override
    public Map<ParsedString, ParsedObject> asMap()
    {
        return map;
    }
}
