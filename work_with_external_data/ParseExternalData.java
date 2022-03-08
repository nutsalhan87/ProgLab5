package work_with_external_data;

import work_with_external_data.parsed_objects.ParsedObject;

import java.io.IOException;

/**
 * The interface contains the header of a method that implements parsing from
 * a data file of a certain type into an object of a special class ParsedObject
 */

public interface ParseExternalData {
    ParsedObject parseFile(String path) throws IOException;
}
