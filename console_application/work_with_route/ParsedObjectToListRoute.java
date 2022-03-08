package console_application.work_with_route;

import route.Coordinates;
import route.Route;
import work_with_external_data.parsed_objects.ParsedObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс реализует единственный метод, который конвертирует объект специального класса @see work_with_external_data.parsed_objects.ParsedObject в
 * список объектов Route
 */

public class ParsedObjectToListRoute {
    private ParsedObjectToListRoute() {
    }

    public static List<Route> convertToListRoute(ParsedObject parsedObject) {
        List<Route> data = new LinkedList<>();

        for (int i = 0; i < parsedObject.asList().size(); ++i) {
            Coordinates coordinates = new Coordinates(
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("coordinates").asMap().get("x").asNumber(),
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("coordinates").asMap().get("y").asNumber().intValue()
            );

            route.first_location.Location from = new route.first_location.Location(
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("first_location").asMap().get("Location").asMap().get("x").asNumber(),
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("first_location").asMap().get("Location").asMap().get("y").asNumber().longValue(),
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("first_location").asMap().get("Location").asMap().get("z").asNumber(),
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("first_location").asMap().get("Location").asMap().get("name").asString()
            );

            route.second_location.Location to = new route.second_location.Location(
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("second_location").asMap().get("Location").asMap().get("x").asNumber().intValue(),
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("second_location").asMap().get("Location").asMap().get("y").asNumber().intValue(),
                    parsedObject.asList().get(i).asMap().get("Route").
                            asMap().get("second_location").asMap().get("Location").asMap().get("z").asNumber().floatValue()
            );

            data.add(new Route(
                    parsedObject.asList().get(i).asMap().get("Route").asMap().get("name").asString(),
                    coordinates,
                    from,
                    to,
                    parsedObject.asList().get(i).asMap().get("Route").asMap().get("distance").asNumber()
            ));
        }

        return data;
    }
}
