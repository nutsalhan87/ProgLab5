package console_application.work_with_route;

import console_application.Input;
import route.Coordinates;
import route.Route;

import java.io.IOException;

/**
 * The class contains a single method that creates an instance of the Route class by entering each data field manually or from a file
 */

public class CreatingNewInstance {
    private CreatingNewInstance() {
    }

    public static Route createNewRouteInstance(Input cin) throws IOException {
        boolean continueKey = false;
        String input;
        System.out.println("Условимся, что пустая строка - это null");

        System.out.println("Задание основных значений полей для объекта класса Route:");
        String rName = null;
        while (!continueKey) {
            System.out.print("Введите имя: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.R_NAME);
                rName = input;
                continueKey = true;
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        Double rDistance = null;
        while (!continueKey) {
            System.out.print("Введите дистанцию: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.R_DISTANCE);
                rDistance = Double.parseDouble(input);
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        System.out.println("Задание основных значений полей для объекта класса Coordinates:");
        Double cX = null;
        while (!continueKey) {
            System.out.print("Введите значение x: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.C_X);
                cX = Double.parseDouble(input);
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        Integer cY = null;
        while (!continueKey) {
            System.out.print("Введите значение y: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.C_Y);
                cY = ((Double) Double.parseDouble(input)).intValue();
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        System.out.println("Задание основных значений полей для объекта класса route.first_location.Location:");
        Double flX = null;
        while (!continueKey) {
            System.out.print("Введите значение x: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.FL_X);
                flX = Double.parseDouble(input);
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            }
        }
        continueKey = false;

        Long flY = null;
        while (!continueKey) {
            System.out.print("Введите значение y: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.FL_Y);
                flY = ((Double) Double.parseDouble(input)).longValue();
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        Double flZ = null;
        while (!continueKey) {
            System.out.print("Введите значение z: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.FL_Z);
                flZ = Double.parseDouble(input);
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            }
        }
        continueKey = false;

        String flName = null;
        while (!continueKey) {
            System.out.print("Введите имя: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.FL_NAME);
                flName = input;
                continueKey = true;
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        System.out.println("Задание основных значений полей для объекта класса route.second_location.Location:");
        Integer slX = null;
        while (!continueKey) {
            System.out.print("Введите значение x: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.SL_X);
                slX = ((Double) Double.parseDouble(input)).intValue();
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }
        }
        continueKey = false;

        Integer slY = null;
        while (!continueKey) {
            System.out.print("Введите значение y: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.SL_Y);
                slY = ((Double) Double.parseDouble(input)).intValue();
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            }
        }
        continueKey = false;

        Float slZ = null;
        while (!continueKey) {
            System.out.print("Введите значение z: ");
            input = cin.nextLine();
            try {
                input = ValuesChecking.checkCondition(input, RouteFields.SL_Z);
                slZ = ((Double) Double.parseDouble(input)).floatValue();
                continueKey = true;
            } catch (NumberFormatException exn) {
                System.out.println("Введите корректное число");
            }
        }

        return new Route(rName, new Coordinates(cX, cY), new route.first_location.Location(flX, flY, flZ, flName),
                new route.second_location.Location(slX, slY, slZ), rDistance);

    }
}
