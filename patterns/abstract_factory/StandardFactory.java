package patterns.abstract_factory;

public class StandardFactory extends Factory {
    @Override
    public Taxi createTaxi(Driver driver, String license) {
        return new StandardTaxi(driver, license);
    }

    @Override
    public Driver createDriver(String name) {
        return new StandardDriver(name);
    }
}
