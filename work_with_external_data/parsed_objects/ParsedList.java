package work_with_external_data.parsed_objects;

import java.util.LinkedList;
import java.util.List;

public class ParsedList extends ParsedObject {
    List<ParsedObject> list;

    public ParsedList()
    {
        super();
        list = new LinkedList<>();
    }

    public void addObject(ParsedObject obj)
    {
        list.add(obj);
    }

    @Override
    public List<ParsedObject> asList()
    {
        return list;
    }
}
