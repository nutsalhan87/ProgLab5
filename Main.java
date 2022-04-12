import consoleapplication.MainInterface;
import consoleapplication.workwithroute.ParsedObjectToListRoute;
import route.Route;
import workwithexternaldata.JSONToParsedObject;
import workwithexternaldata.parsedobjects.ParsedObject;

import java.io.File;
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
            if (!(new File(System.getenv("Lab5Data")).exists())) {
                System.out.println("Файла данных не существует");
                return;
            }
            if ( !(new File(System.getenv("Lab5Data")).canWrite() && new File(System.getenv("Lab5Data")).canRead())) {
                System.out.println("Ввод или вывод в данный файл не доступен.");
                return;
            }
        }
        catch (NullPointerException exc) {
            System.out.println("Заданная переменная окружения отсутствует");
        }

        ParsedObject parsedObject = new JSONToParsedObject().parseFile(System.getenv("Lab5Data"));
        List<Route> data = new LinkedList<>(ParsedObjectToListRoute.convertToListRoute(parsedObject));
        MainInterface mainInterface = new MainInterface();
        mainInterface.startMainInterface(data, () -> new Scanner(System.in).nextLine());
    }
}
