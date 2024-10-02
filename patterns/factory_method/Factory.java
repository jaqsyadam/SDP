package patterns.factory_method;

public abstract class Factory {
    public abstract Taxi createTaxi(String driverName, String license);
}
