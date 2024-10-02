package patterns.abstract_factory;

public abstract class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public abstract void drive();
}
