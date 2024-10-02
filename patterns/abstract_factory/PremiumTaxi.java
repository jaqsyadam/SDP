package patterns.abstract_factory;

public class PremiumTaxi extends Taxi {
    public PremiumTaxi(Driver driver, String license) {
        super(driver, license);
    }

    @Override
    public void takePassenger(String passenger) {
        System.out.println("Premium ride for passenger " + passenger);
    }
}
