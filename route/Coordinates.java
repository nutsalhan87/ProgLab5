package route;

import java.util.Comparator;

public class Coordinates implements Comparable<Coordinates>
{
    private double x; //Значение поля должно быть больше -140
    private Integer y; //Поле не может быть null

    public Coordinates(double x, Integer y)
    {
        if (x <= -140 || y == null)
        {
            throw new IllegalArgumentException();
        }

        this.x = x;
        this.y = y;
    }

    public void setX(double x)
    {
        if(x <= -140)
        {
            throw new IllegalArgumentException();
        }

        this.x = x;
    }

    public void setY(Integer y)
    {
        if(y == null)
        {
            throw new IllegalArgumentException();
        }
    }

    public double getX()
    {
        return x;
    }

    public Integer getY()
    {
        return y;
    }

    @Override
    public int compareTo(Coordinates anotherCoordinates)
    {
        double coordModule1 = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        double coordModule2 = Math.sqrt(Math.pow(anotherCoordinates.x, 2) + Math.pow(anotherCoordinates.y, 2));

        if (coordModule1 > coordModule2) return 1;
        else if (coordModule1 < coordModule2) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Coordinates: " +
                "x=" + x +
                ", y=" + y;
    }
}
