package console_application;

import console_application.work_with_route.CreatingNewInstance;
import console_application.work_with_route.ListRouteToFileJSON;
import route.Route;

import java.io.*;
import java.util.*;

/**
 * A class that implements a console interface for data management
 * @author Nutsalhan Nutsalhanov
 * @version 1.0
 */

public class MainInterface {
    /**
     * Main constructor
     */
    public MainInterface() {
    }

    /**
     * The method launches a console interface for data management
     * @param data - collection of instances of the Route class
     * @param input - lamda-method which implements functional interface Input
     */
    public void startMainInterface(List<Route> data, Input input) {
        String inputLine;
        while (true) {
            try {
                inputLine = input.nextLine();
                if (inputLine == null)
                    return;
            } catch (IOException exio) {
                System.out.println("Такого файла нет");
                return;
            }

            try {
                execCommand(inputLine, data, input);
            } catch (WrongCommand exc) {
                System.out.println(exc.getMessage());
            } catch (ExitProgram ext) {
                System.out.println(ext.getMessage());
                break;
            } catch (NumberFormatException exn) {
                System.out.println("В качестве id введите целое число");
            } catch (IOException exf) {
                System.out.println("Файл не найден, попробуйте снова");
            }
        }
    }

    /**
     * The method is responsible for processing and executing commands
     * @param command - command
     * @param data - collection of instances of the Route class
     * @param input - lamda-method which implements functional interface Input
     * @throws WrongCommand - an exception thrown when the command is incorrect
     * @throws ExitProgram - the exception required to implement the exit command that exits the program
     * @throws NumberFormatException - exception thrown when entering an incorrect number
     * @throws IOException - an exception thrown if there is no access to the file or there are other I/O errors
     */
    private void execCommand(String command, List<Route> data, Input input) throws WrongCommand, ExitProgram, NumberFormatException, IOException {
        List<String> splittedCommand = new LinkedList<>(List.of(command.split("\s+")));
        if (command.equals("") || splittedCommand.size() == 0) {
            throw new IllegalArgumentException("Введена пустая строка");
        }
        if (splittedCommand.get(0).equals("")) {
            splittedCommand.remove(0);
        }

        switch (splittedCommand.get(0)) {
            case "help":
                if (splittedCommand.size() == 1)
                    help();
                else
                    throw new WrongCommand();
                break;
            case "info":
                if (splittedCommand.size() == 1)
                    info(data);
                else
                    throw new WrongCommand();
                break;
            case "show":
                if (splittedCommand.size() == 1)
                    show(data);
                else
                    throw new WrongCommand();
                break;
            case "add":
                if (splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    add(data, input);
                else if (splittedCommand.size() == 2 && !splittedCommand.get(1).equals("Route"))
                    throw new WrongCommand("В коллекцию можно дабовить только объект класса Route");
                else
                    throw new WrongCommand();
                break;
            case "update":
                if (splittedCommand.size() == 2)
                    update(data, splittedCommand.get(1), input);
                else
                    throw new WrongCommand();
                break;
            case "remove_by_id":
                if (splittedCommand.size() == 2)
                    removeById(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "clear":
                if (splittedCommand.size() == 1)
                    clear(data);
                else
                    throw new WrongCommand();
                break;
            case "save":
                if(splittedCommand.size() == 1)
                    save(data);
                else
                    throw new WrongCommand();
                break;
            case "execute_script":
                if (splittedCommand.size() == 2)
                    executeScript(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "exit":
                if (splittedCommand.size() == 1)
                    throw new ExitProgram();
                else
                    throw new WrongCommand();
            case "add_if_max":
                if (splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    addIfMax(data, input);
                else
                    throw new WrongCommand();
                break;
            case "remove_greater":
                if (splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    removeGreater(data, input);
                else
                    throw new WrongCommand();
                break;
            case "remove_lower":
                if (splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    removeLower(data, input);
                else
                    throw new WrongCommand();
                break;
            case "remove_any_by_distance":
                if (splittedCommand.size() == 2)
                    removeAnyByDistance(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "filter_contains_name":
                if (splittedCommand.size() == 2)
                    filterContainsName(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "filter_starts_with_name":
                if (splittedCommand.size() == 2)
                    filterStartsWithName(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            default:
                throw new WrongCommand();
        }
    }

    /**
     * Выводит справку по доступным командам
     */
    private void help() {
        System.out.println("help: вывести справку по доступным командам\n" +
                "info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element}: добавить новый элемент в коллекцию\n" +
                "update id: обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id: удалить элемент из коллекции по его id\n" +
                "clear: очистить коллекцию\n" +
                "save: сохранить коллекцию в файл\n" +
                "execute_script file_name: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit: завершить программу (без сохранения в файл)\n" +
                "add_if_max {element}: добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "remove_greater {element}: удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower {element}: удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "remove_any_by_distance distance: удалить из коллекции один элемент, значение поля distance которого эквивалентно заданному\n" +
                "filter_contains_name name: вывести элементы, значение поля name которых содержит заданную подстроку\n" +
                "filter_starts_with_name name: вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    /**
     * Вывод информации о коллекции
     */
    private void info(List<Route> data) {
        System.out.println("Тип коллекции: " + data.getClass().getName() + "\n" +
                "Тип данных, хранимых в коллекции: " + Route.class.getName() + "\n" +
                "Количество элементов в коллекции: " + data.size());
    }

    /**
     * Вывод всех элементов коллекции в строковм представлении
     */
    private void show(List<Route> data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i) + "\n");
        }
    }

    /**
     * Добавление нового элемента в коллекцию
     */
    private void add(List<Route> data, Input input) throws IOException {
        data.add(CreatingNewInstance.createNewRouteInstance(input));
        System.out.println("Новый экземпляр класса успешно добавлен в коллекцию");
    }

    /**
     * Обновление элемента коллекции по id
     */
    private void update(List<Route> data, String id, Input input) throws NumberFormatException, IOException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(Integer.decode(id))) {
                data.get(i).updateValues(CreatingNewInstance.createNewRouteInstance(input));
                System.out.println("Объект с id " + id + " успешно изменен");
                return;
            }
        }
        System.out.println("Объекта с таким id нет");
    }

    /**
     * Удаление элемента коллекции по id
     */
    private void removeById(List<Route> data, String id) throws NumberFormatException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(Integer.decode(id))) {
                data.remove(i);
                System.out.println("Объект с id " + id + " успешно удален");
                return;
            }
        }
        System.out.println("Объекта с таким id нет");
    }

    /**
     * Очистка коллекции
     */
    private void clear(List<Route> data) {
        data.clear();
        System.out.println("Коллекция успешно очищена");
    }

    /**
     * Сохранение элементов коллекции в файл в виде данных в формате JSON
     */
    private void save(List<Route> data) throws IOException {
        new ListRouteToFileJSON().saveInFile("C:\\Users\\nutsa\\Desktop", data);
        System.out.println("Коллекция сохранена в файл");
    }

    /**
     * Выполнение команд из внешнего файла
     */
    private void executeScript(List<Route> data, String fileName) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        new MainInterface().startMainInterface(data, bufferedReader::readLine);
    }

    /**
     * Добавление нового элемента в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
     */
    private void addIfMax(List<Route> data, Input input) throws IOException {
        Route toAddIfMax = CreatingNewInstance.createNewRouteInstance(input);

        if (toAddIfMax.compareTo(Collections.max(data)) > 0) {
            data.add(toAddIfMax);
            System.out.println("Новый объект успешно добавлен");
        } else
            System.out.println("Новый объект не больше максимального элемента коллекции, потому не был добавлен");
    }

    /**
     * Удаление из коллекции всех элементов, превышающих заданный
     */
    private void removeGreater(List<Route> data, Input input) throws IOException {
        Route forComparison = CreatingNewInstance.createNewRouteInstance(input);

        for (int i = data.size() - 1; i >= 0; i--) {
            if (forComparison.compareTo(data.get(i)) < 0)
                data.remove(i);
        }

        System.out.println("Элементы коллекции, превышающие заданный, успешно удалены");
    }

    /**
     * Удаление из коллекции всех элементов, которые меньше заданного
     */
    private void removeLower(List<Route> data, Input input) throws IOException {
        Route forComparison = CreatingNewInstance.createNewRouteInstance(input);

        for (int i = data.size() - 1; i >= 0; i--) {
            if (forComparison.compareTo(data.get(i)) > 0)
                data.remove(i);
        }

        System.out.println("Элементы коллекции, которые меньше заданного, успешно удалены");
    }

    /**
     * Удаление из коллекции всех элементов, значение расстояния которого равно заданному
     */
    private void removeAnyByDistance(List<Route> data, String dist) throws NumberFormatException {
        boolean isFound = false;
        for (int i = 0; i < data.size(); i++) {
            if (Math.abs(data.get(i).getDistance() - Double.parseDouble(dist)) < 0.00000001d) {
                data.remove(i);
                isFound = true;
                break;
            }
        }
        if (isFound)
            System.out.println("Первый встречный элемент в коллекции, значение distance которого равно заданному, удален");
        else
            System.out.println("Элемент, значение distance которого равно заданному, не найден");
    }

    /**
     * Вывод элементов, значение поля name которых содержит заданную подстроку
     */
    private void filterContainsName(List<Route> data, String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().contains(name))
                System.out.println(data.get(i) + "\n");
        }
    }

    /**
     * Вывод элементов, значение поля name которых начинается с заданной подстроки
     */
    private void filterStartsWithName(List<Route> data, String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().startsWith(name))
                System.out.println(data.get(i) + "\n");
        }
    }
}
