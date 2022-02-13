package console_application;

import console_application.work_with_route.CreatingNewInstance;
import route.Route;

import java.util.*;

public class MainInterface {
    public MainInterface() {}

    public void startMainInterface(List<Route> data)
    {
        String inputLine;
        Scanner cin = new Scanner(System.in);
        while(true)
        {
            inputLine = cin.nextLine();

            try
            {
                execCommand(inputLine, data);
            }
            catch (WrongCommand exc)
            {
                System.out.println(exc.getMessage());
            }
            catch (ExitProgram ext)
            {
                System.out.println(ext.getMessage());
                break;
            }
            catch (NumberFormatException exn)
            {
                System.out.println("В качестве id введите целое число");
            }
        }
    }

    private void execCommand(String command, List<Route> data) throws WrongCommand, ExitProgram, NumberFormatException
    {
        List<String> splittedCommand = new LinkedList<>(List.of(command.split("\s+")));

        if(command.equals("") || splittedCommand.size() == 0)
        {
            throw new IllegalArgumentException("Введена пустая строка");
        }
        if(splittedCommand.get(0).equals(""))
        {
            splittedCommand.remove(0);
        }

        switch (splittedCommand.get(0))
        {
            case "help":
                if(splittedCommand.size() == 1)
                    help();
                else
                    throw new WrongCommand();
                break;
            case "info":
                if(splittedCommand.size() == 1)
                    info(data);
                else
                    throw new WrongCommand();
                break;
            case "show":
                if(splittedCommand.size() == 1)
                    show(data);
                else
                    throw new WrongCommand();
                break;
            case "clear":
                if(splittedCommand.size() == 1)
                    clear(data);
                else
                    throw new WrongCommand();
                break;
            case "add":
                if(splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    add(data);
                else if(splittedCommand.size() == 2 && !splittedCommand.get(1).equals("Route"))
                    throw new WrongCommand("В коллекцию можно дабовить только объект класса Route");
                else
                    throw new WrongCommand();
                break;
            case "update":
                if(splittedCommand.size() == 2)
                    update(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "remove_by_id":
                if(splittedCommand.size() == 2)
                    remove_by_id(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "exit":
                if(splittedCommand.size() == 1)
                    throw new ExitProgram();
                else
                    throw new WrongCommand();
            case "add_if_max":
                if(splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    add_if_max(data);
                else
                    throw new WrongCommand();
                break;
            case "remove_greater":
                if(splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    remove_greater(data);
                else
                    throw new WrongCommand();
                break;
            case "remove_lower":
                if(splittedCommand.size() == 2 && splittedCommand.get(1).equals("Route"))
                    remove_lower(data);
                else
                    throw new WrongCommand();
                break;
            case "remove_any_by_distance":
                if(splittedCommand.size() == 2)
                    remove_any_by_distance(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "filter_contains_name":
                if(splittedCommand.size() == 2)
                    filter_contains_name(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            case "filter_starts_with_name":
                if(splittedCommand.size() == 2)
                    filter_starts_with_name(data, splittedCommand.get(1));
                else
                    throw new WrongCommand();
                break;
            default:
                throw new WrongCommand();
        }
    }

    private void help()
    {
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

    private void info(List<Route> data)
    {
        System.out.println("Тип коллекции: " + data.getClass().getName() + "\n" +
                "Тип данных, хранимых в коллекции: " + Route.class.getName() + "\n" +
                "Количество элементов в коллекции: " + data.size());
    }

    private void show(List<Route> data)
    {
        for (int i = 0; i < data.size(); i++)
        {
            System.out.println(data.get(i) + "\n");
        }
    }

    private void add(List<Route> data)
    {
        data.add(CreatingNewInstance.createNewRouteInstance());
        System.out.println("Новый экземпляр класса успешно добавлен в коллекцию");
    }

    private void update(List<Route> data, String id) throws NumberFormatException
    {
        for (int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getId().equals(Integer.decode(id)))
            {
                data.get(i).updateValues(CreatingNewInstance.createNewRouteInstance());
                System.out.println("Объект с id " + id + " успешно изменен");
                return;
            }
        }
        System.out.println("Объекта с таким id нет");
    }

    private void remove_by_id(List<Route> data, String id) throws NumberFormatException
    {
        for (int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getId().equals(Integer.decode(id)))
            {
                data.remove(i);
                System.out.println("Объект с id " + id + " успешно удален");
                return;
            }
        }
        System.out.println("Объекта с таким id нет");
    }

    private void clear(List<Route> data)
    {
        data.clear();
        System.out.println("Коллекция успешно очищена");
    }

    //TODO: доделать
    private void save(List<Route> data)
    {
        System.out.println("Коллекция сохранена в файл");
    }

    private void add_if_max(List<Route> data)
    {
        Route toAddIfMax = CreatingNewInstance.createNewRouteInstance();

        if(toAddIfMax.compareTo(Collections.max(data)) > 0)
        {
            data.add(toAddIfMax);
            System.out.println("Новый объект успешно добавлен");
        }
        else
            System.out.println("Новый объект не больше максимального элемента коллекции, потому не был добавлен");
    }

    private void remove_greater(List<Route> data)
    {
        Route forComparison = CreatingNewInstance.createNewRouteInstance();

        for (int i = data.size() - 1; i >= 0; i--)
        {
            if(forComparison.compareTo(data.get(i)) < 0)
                data.remove(i);
        }

        System.out.println("Элементы коллекции, превышающие заданный, успешно удалены");
    }

    private void remove_lower(List<Route> data)
    {
        Route forComparison = CreatingNewInstance.createNewRouteInstance();

        for (int i = data.size() - 1; i >= 0; i--)
        {
            if(forComparison.compareTo(data.get(i)) > 0)
                data.remove(i);
        }

        System.out.println("Элементы коллекции, которые меньше заданного, успешно удалены");
    }

    private void remove_any_by_distance(List<Route> data, String dist) throws NumberFormatException
    {
        boolean isFound = false;
        for (int i = 0; i < data.size(); i++)
        {
            if(Math.abs(data.get(i).getDistance() - Double.parseDouble(dist)) < 0.00000001d)
            {
                data.remove(i);
                isFound = true;
                break;
            }
        }
        if(isFound)
            System.out.println("Первый встречный элемент в коллекции, значение distance которого равно заданному, удален");
        else
            System.out.println("Элемент, значение distance которого равно заданному, не найден");
    }

    private void filter_contains_name(List<Route> data, String name)
    {
        for (int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getName().contains(name))
                System.out.println(data.get(i) + "\n");
        }
    }

    private void filter_starts_with_name(List<Route> data, String name)
    {
        for (int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getName().startsWith(name))
                System.out.println(data.get(i) + "\n");
        }
    }
}