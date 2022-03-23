import console_application.MainInterface;
import console_application.work_with_route.ParsedObjectToListRoute;
import route.Route;
import work_with_external_data.JSONToParsedObject;
import work_with_external_data.parsed_objects.ParsedObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class which contains a single method which reads data from file and starts console interface
 */

public class Main {
    public static void main(String args[]) throws IOException {
        try {
            ParsedObject parsedObject = new JSONToParsedObject().parseFile(System.getenv("Lab5Data"));
            List<Route> data = new LinkedList<>(ParsedObjectToListRoute.convertToListRoute(parsedObject));
            MainInterface mainInterface = new MainInterface();
            mainInterface.startMainInterface(data, () -> new Scanner(System.in).nextLine());
        }
        catch (IOException ioexc) {
            System.out.println("Нет доступа к файлу");
        }
    }
}
