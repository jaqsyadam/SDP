package patterns;

import patterns.abstract_factory.PremiumFactory;
import patterns.abstract_factory.StandardFactory;
import patterns.abstract_factory.Taxi;
import patterns.builder.Driver;
import patterns.factory_method.Factory;
import patterns.factory_method.PremiumTaxiFactory;
import patterns.factory_method.StandardTaxiFactory;
import patterns.singleton.DriverManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите паттерн для запуска:");
        System.out.println("1. Singleton");
        System.out.println("2. Prototype");
        System.out.println("3. Builder");
        System.out.println("4. Factory Method");
        System.out.println("5. Abstract Factory");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Singleton
                DriverManager driverManager = DriverManager.getInstance();
                String driver = driverManager.findNearestDriver("Location A");
                System.out.println("Driver: " + driver);
                break;
            case 2:
                // Prototype
                patterns.prototype.Driver originalDriver = new patterns.prototype.Driver("John Doe", "Toyota Prius");
                System.out.println("Original Driver: " + originalDriver.getName());
                patterns.prototype.Driver clonedDriver = originalDriver.clone();
                clonedDriver.setName("Jane Doe");
                System.out.println("Cloned Driver: " + clonedDriver.getName());
                break;
            case 3:
                // Builder
                Driver driverBuilder = new Driver.DriverBuilder()
                        .withName("Johnny Silverhand")
                        .withCarModel("Porsche 911")
                        .withLicenseNumber("XYZ12345")
                        .withExperienceYears(5)
                        .isAvailable(true)
                        .build();
                System.out.println(driverBuilder);
                break;
            case 4:
                // Factory Method
                Factory factory = new StandardTaxiFactory();
                patterns.factory_method.Taxi taxi = factory.createTaxi("Daniele", "XYZ12345");
                taxi.takePassenger("Alex");

                factory = new PremiumTaxiFactory();
                taxi = factory.createTaxi("Daniele", "XYZ12345");
                taxi.takePassenger("Alex");
                break;
            case 5:
                // Abstract Factory
                patterns.abstract_factory.Factory abstractFactory = new StandardFactory();
                patterns.abstract_factory.Driver standardDriver = abstractFactory.createDriver("Daniele");
                Taxi standardTaxi = abstractFactory.createTaxi(standardDriver, "XYZ12345");
                standardTaxi.takePassenger("John");

                abstractFactory = new PremiumFactory();
                patterns.abstract_factory.Driver premiumDriver = abstractFactory.createDriver("Johny");
                Taxi premiumTaxi = abstractFactory.createTaxi(premiumDriver, "ABC98765");
                premiumTaxi.takePassenger("John");
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }
}
