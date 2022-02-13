package work_with_external_data;

import work_with_external_data.parsed_objects.ParsedObject;

import java.io.*;

public class JSONToParsedObject implements WorkWithExternalData
{
    public JSONToParsedObject() {}

    public ParsedObject parseFile(String path) throws FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        ParsedObject data = new ParsedObject();

        return data;
    }

    public void saveInFile(String path, ParsedObject data) throws FileNotFoundException
    {

    }
}
