package work_with_external_data.parsed_objects;

public class ParsedString extends ParsedObject
{
    String string;

    public ParsedString(String str)
    {
        super();
        string = str;
    }

    @Override
    public String asString()
    {
        return string;
    }
}
