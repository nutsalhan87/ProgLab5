package console_application.work_with_route;

import route.Route;
import work_with_external_data.SaveData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The class contains a single method that is an implementation of the functional interface Input and
 * which converts a collection of Route objects to JSON data format, and then saves the result to a file
 */

public class ListRouteToFileJSON implements SaveData<Route> {
    public ListRouteToFileJSON() {}

    @Override
    public void saveInFile(List<Route> data) throws IOException {
        try {
            File file = new File(System.getenv("Lab5Data"));
            FileWriter writer = new FileWriter(file);

            writer.write("[\n");
            String json;
            for(int i = 0; i < data.size(); ++i) {
                if(i != data.size() - 1)
                    json = "  {\n" + data.get(i).toJSON(4) + "\n  },\n";
                else
                    json = "  {\n" + data.get(i).toJSON(4) + "\n  }\n";
                writer.write(json);
            }
            writer.write("]");
            writer.close();
        }
        catch (IOException exc) {
            System.out.println("Нет доступа к файлу");
        }
    }
}
