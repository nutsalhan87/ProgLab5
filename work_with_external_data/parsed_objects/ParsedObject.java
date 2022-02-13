package work_with_external_data.parsed_objects;

import java.util.List;
import java.util.Map;

public class ParsedObject {
    protected boolean isNull;

    public ParsedObject()
    {
        isNull = false;
    }

    public List<ParsedObject> asList()
    {
        return null;
    }

    public Map<ParsedString, ParsedObject> asMap()
    {
        return null;
    }

    public String asString()
    {
        return null;
    }

    public Double asNumber()
    {
        return null;
    }

    public boolean isNull()
    {
        return isNull;
    }
}
