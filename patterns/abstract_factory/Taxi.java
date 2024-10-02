package patterns.abstract_factory;

public abstract class Taxi {
    private Driver driver;
    private String license;

    public Taxi(Driver driver, String license) {
        this.driver = driver;
        this.license = license;
    }

    public abstract void takePassenger(String passenger);
}
