package patterns.prototype;

public class Driver implements Prototype {
    private String name;
    private String carModel;

    public Driver(String name, String carModel) {
        this.name = name;
        this.carModel = carModel;
    }

    public Driver clone() {
        return new Driver(this.name, this.carModel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
