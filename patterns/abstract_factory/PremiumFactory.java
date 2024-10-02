package patterns.abstract_factory;

public class PremiumFactory extends Factory {
    @Override
    public Taxi createTaxi(Driver driver, String license) {
        return new PremiumTaxi(driver, license);
    }

    @Override
    public Driver createDriver(String name) {
        return new PremiumDriver(name);
    }
}
