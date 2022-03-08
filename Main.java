import console_application.MainInterface;
import console_application.work_with_route.ListRouteToFileJSON;
import console_application.work_with_route.ParsedObjectToListRoute;
import route.Coordinates;
import route.Route;
import work_with_external_data.JSONToParsedObject;
import work_with_external_data.parsed_objects.ParsedObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        ParsedObject parsedObject = new JSONToParsedObject().parseFile(System.getenv("Lab5Data"));
        List<Route> data = new LinkedList<>(ParsedObjectToListRoute.convertToListRoute(parsedObject));
        data.add(new Route("nameandname",
                new Coordinates(1, 1),
                new route.first_location.Location(1, 1L, 1d, "name"),
                new route.second_location.Location(1, 1, 1),
                2));
        data.add(new Route("ameandname",
                new Coordinates(100, 100),
                new route.first_location.Location(100, 100L, 100d, "name"),
                new route.second_location.Location(100, 100, 100),
                200));

        new ListRouteToFileJSON().saveInFile("C:\\Users\\nutsa\\Desktop", data);
        MainInterface mainInterface = new MainInterface();
        mainInterface.startMainInterface(data, () -> {
            return new Scanner(System.in).nextLine();
        });
    }
}
