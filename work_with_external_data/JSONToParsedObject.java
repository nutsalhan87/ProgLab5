package work_with_external_data;

import work_with_external_data.parsed_objects.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;

/**
 * Класс содержит единственный метод для парсинга JSON-данных из файла в объект специального класса: @see work_with_external_data.parsed_objects.ParsedObject
 */

public class JSONToParsedObject implements ParseExternalData {
    public JSONToParsedObject() {
    }

    public ParsedObject parseFile(String path) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String data = "";
        String input;
        while (true) {
            input = reader.readLine();
            if (input == null)
                break;
            data += input;
        }
        List<String> splitted = new LinkedList<>(List.of(data.split(",")));
        Pattern pattern = Pattern.compile("\\s*([^\\s:\\[\\]{}]*[:\\[\\]{}]?)\\n?");
        List<String> blocks = new LinkedList<>();
        for (int i = 0; i < splitted.size(); ++i) {
            Matcher matcher = pattern.matcher(splitted.get(i));
            while (matcher.find() && !matcher.group(1).equals(""))
                blocks.add(matcher.group(1));
        }

        int[] index = {1};
        ParsedObject parsedObject = parseList(blocks, index);

        return parsedObject;
    }

    public ParsedList parseList(List<String> blocks, int[] index) {
        ParsedList parsedObject = new ParsedList();
        for (; index[0] < blocks.size(); ++index[0]) {
            switch (blocks.get(index[0]).charAt(blocks.get(index[0]).length() - 1)) {
                case '[':
                    ++index[0];
                    parsedObject.addObject(parseList(blocks, index));
                    break;
                case ']':
                    return parsedObject;
                case '{':
                    ++index[0];
                    parsedObject.addObject(parseMap(blocks, index));
                    break;
                default:
                    parsedObject.addObject(parseObject(blocks.get(index[0])));
                    break;
            }
        }
        return parsedObject;
    }

    public ParsedMap parseMap(List<String> blocks, int[] index) {
        ParsedMap parsedObject = new ParsedMap();
        for (; index[0] < blocks.size() - 1; ++index[0]) {
            switch (blocks.get(index[0]).charAt(blocks.get(index[0]).length() - 1)) {
                case ':':
                    ++index[0];
                    parsedObject.addObject(parseString(blocks.get(index[0] - 1)), parseValue(blocks, index));
                    break;
                case '}':
                    return parsedObject;
            }
        }
        return parsedObject;
    }

    public ParsedObject parseValue(List<String> blocks, int[] index) {
        switch (blocks.get(index[0]).charAt(blocks.get(index[0]).length() - 1)) {
            case '{':
                ++index[0];
                return parseMap(blocks, index);
            case '[':
                ++index[0];
                return parseList(blocks, index);
            default:
                return parseObject(blocks.get(index[0]));
        }
    }

    public ParsedObject parseObject(String block) {
        if (Pattern.compile("(null)").matcher(block).find())
            return new ParsedNull();

        if (Pattern.compile("\"(.*)\"").matcher(block).find()) {
            Matcher matcher = Pattern.compile("\"(.*)\"").matcher(block);
            matcher.find();
            return new ParsedString(matcher.group(1));
        }

        if (Pattern.compile("(-?\\d+\\.?\\d*)").matcher(block).find()) {
            Matcher matcher = Pattern.compile("(-?\\d+\\.?\\d*)").matcher(block);
            matcher.find();
            return new ParsedNumber(Double.parseDouble(matcher.group(1)));
        }

        return new ParsedObject();
    }

    public String parseString(String block) {
        Pattern pattern = Pattern.compile("\"(.*)\"");
        Matcher matcher = pattern.matcher(block);
        matcher.find();
        return matcher.group(1);
    }
}
