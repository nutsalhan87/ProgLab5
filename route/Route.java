package route;

import java.util.Comparator;

public class Route implements Comparable<Route>
{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private route.first_location.Location from; //Поле не может быть null
    private route.second_location.Location to; //Поле не может быть null
    private double distance; //Значение поля должно быть больше 1

    private static int instances = 0;

    public Route(String name, Coordinates coordinates, route.first_location.Location from,
                 route.second_location.Location to, double distance) throws IllegalArgumentException
    {
        if (name == null || coordinates == null || from == null || to == null || name.equals("") || distance <= 1d)
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;
        creationDate = new java.util.Date();

        this.id = instances + 1;
        ++instances;
    }

    public void updateValues(Route toCopyValuesFrom)
    {
        if (toCopyValuesFrom.name == null || toCopyValuesFrom.coordinates == null || toCopyValuesFrom.from == null ||
                toCopyValuesFrom.to == null || toCopyValuesFrom.name.equals("") || toCopyValuesFrom.distance <= 1d)
        {
            throw new IllegalArgumentException();
        }

        this.name = toCopyValuesFrom.name;
        this.coordinates = toCopyValuesFrom.coordinates;
        this.from = toCopyValuesFrom.from;
        this.to = toCopyValuesFrom.to;
        this.distance = toCopyValuesFrom.distance;
    }

    public void setName(String name)
    {
        if(name == null || name.equals(""))
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates)
    {
        if(coordinates == null)
        {
            throw new IllegalArgumentException();
        }

        this.coordinates = coordinates;
    }

    public void setFrom(route.first_location.Location from)
    {
        if(from == null)
        {
            throw new IllegalArgumentException();
        }

        this.from = from;
    }

    public void setTo(route.second_location.Location to)
    {
        if(to == null)
        {
            throw new IllegalArgumentException();
        }

        this.to = to;
    }

    public void setDistance(double distance)
    {
        if(distance <= 1.0)
        {
            throw new IllegalArgumentException();
        }

        this.distance = distance;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public java.util.Date getCreationDate()
    {
        return creationDate;
    }

    public route.first_location.Location getFrom()
    {
        return from;
    }

    public route.second_location.Location getTo()
    {
        return to;
    }

    public double getDistance()
    {
        return distance;
    }

    @Override
    public int compareTo(Route anotherRoute)
    {
        if (this.distance > anotherRoute.distance) return 1;
        else if (this.distance < anotherRoute.distance) return -1;
        else
        {
            if(this.coordinates.compareTo(anotherRoute.coordinates) != 0) return this.coordinates.compareTo(anotherRoute.coordinates);
            else
            {
                if(this.from.compareTo(anotherRoute.from) != 0) return this.from.compareTo(anotherRoute.from);
                else
                {
                    if(this.to.compareTo(anotherRoute.to) != 0) return this.to.compareTo(anotherRoute.to);
                    else
                    {
                        return this.name.compareTo(anotherRoute.name);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Route: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", distance=" + distance + "\n" +
                "Route.coordinates: " + coordinates + "\n" +
                "Route.from: " + from + "\n" +
                "Route.to: " + to;
    }
}
