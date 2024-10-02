package patterns.abstract_factory;

public class StandardTaxi extends Taxi {
    public StandardTaxi(Driver driver, String license) {
        super(driver, license);
    }

    @Override
    public void takePassenger(String passenger) {
        System.out.println("Regular ride for passenger " + passenger);
    }
}
