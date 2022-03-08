package route.first_location;

/**
 * The class stores the location, or rather the coordinates in three-dimensional space and the name of the place
 */

public class Location implements Comparable<route.first_location.Location> {
    private double x;
    private Long y; //Поле не может быть null
    private double z;
    private String name; //Строка не может быть пустой, Поле не может быть null

    public Location(double x, Long y, double z, String name) {
        if (y == null || name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }

        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(Long y) {
        if (y == null) {
            throw new IllegalArgumentException();
        }

        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public double getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(route.first_location.Location anotherLoc) {
        double coordModule1 = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        double coordModule2 = Math.sqrt(Math.pow(anotherLoc.x, 2) + Math.pow(anotherLoc.y, 2) + Math.pow(anotherLoc.z, 2));

        if (coordModule1 > coordModule2) return 1;
        else if (coordModule1 < coordModule2) return -1;
        else return this.name.compareTo(anotherLoc.name);
    }

    @Override
    public String toString() {
        return "Location: " +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'';
    }

    public String toJSON(int deep) {
        String paragraph = " ";
        return  "\"first_location\": \n " +
                paragraph.repeat(deep) + "{\n" +
                paragraph.repeat(deep + 2) + "\"Location\":\n" +
                paragraph.repeat(deep + 2) + "{\n" +
                paragraph.repeat(deep + 4) + "\"x\": " + x + ",\n" +
                paragraph.repeat(deep + 4) + "\"y\": " + y + ",\n" +
                paragraph.repeat(deep + 4) + "\"y\": " + z + ",\n" +
                paragraph.repeat(deep + 4) + "\"name\": " + name + "\n" +
                paragraph.repeat(deep + 2) + "}\n" +
                paragraph.repeat(deep) + "}";
    }
}
