package work_with_external_data.parsed_objects;

/**
 * A special class whose objects store parsing data in the form of null
 */

public class ParsedNull extends ParsedObject {
    public ParsedNull() {
        super();
        isNull = true;
    }
}
