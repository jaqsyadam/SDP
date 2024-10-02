package patterns.abstract_factory;

public class StandardDriver extends Driver {
    public StandardDriver(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println("Standard driver driving.");
    }
}
