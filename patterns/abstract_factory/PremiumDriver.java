package patterns.abstract_factory;

public class PremiumDriver extends Driver {
    public PremiumDriver(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println("Premium driver driving.");
    }
}
