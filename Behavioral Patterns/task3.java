import java.util.Iterator;
import java.util.List;

// Driver class to represent a driver
class Driver {
    private String name;
    private double distance;

    public Driver(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }
}

// Collection class that implements Iterable
class DriverCollection implements Iterable<Driver> {
    private List<Driver> drivers;

    public DriverCollection(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public Iterator<Driver> iterator() {
        return drivers.iterator();
    }
}

// Main class to demonstrate the simplified iteration
public class DriverIteratorSystem {
    public static void main(String[] args) {
        List<Driver> drivers = List.of(
            new Driver("John", 5.0),
            new Driver("Alice", 3.2),
            new Driver("Bob", 7.8)
        );

        DriverCollection driverCollection = new DriverCollection(drivers);

        for (Driver driver : driverCollection) {
            System.out.println("Driver " + driver.getName() + " is " + driver.getDistance() + " km away.");
        }
    }
}
