import console_application.MainInterface;
import route.Coordinates;
import route.Route;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        List<Route> data = new LinkedList<>();
        data.add(new Route("nameandname",
                new Coordinates(1, 1),
                new route.first_location.Location(1, 1L, 1d, "name"),
                new route.second_location.Location(1, 1, 1), 2));
        data.add(new Route("ameandname",
                new Coordinates(100, 100),
                new route.first_location.Location(100, 100L, 100d, "name"),
                new route.second_location.Location(100, 100, 100), 200));

        MainInterface mainInterface = new MainInterface();
        mainInterface.startMainInterface(data, () -> {return new Scanner(System.in).nextLine();});
    }
}
