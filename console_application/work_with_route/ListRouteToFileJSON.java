package console_application.work_with_route;

import route.Route;
import work_with_external_data.SaveData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс содержит единственный метод, который является реализацией функционального интерфейса @see console_application.Input и который
 * конвертирует коллекцию объектов Route в формат данных JSON, а после сохраняет результат в файл
 */

public class ListRouteToFileJSON implements SaveData<Route> {
    public ListRouteToFileJSON() {}

    @Override
    public void saveInFile(String path, List<Route> data) throws IOException {
        File file = new File(path, "savedData.txt");
        file.createNewFile();
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
}
