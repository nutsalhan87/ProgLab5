package work_with_external_data;

import work_with_external_data.parsed_objects.ParsedObject;

import java.io.FileNotFoundException;

public interface WorkWithExternalData {
    public ParsedObject parseFile(String path) throws FileNotFoundException;
    public void saveInFile(String path, ParsedObject data) throws FileNotFoundException;
}
