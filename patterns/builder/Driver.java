package patterns.builder;

public class Driver {
    private String name;
    private String carModel;
    private String licenseNumber;
    private int experienceYears;
    private boolean isAvailable;

    private Driver(DriverBuilder builder) {
        this.name = builder.name;
        this.carModel = builder.carModel;
        this.licenseNumber = builder.licenseNumber;
        this.experienceYears = builder.experienceYears;
        this.isAvailable = builder.isAvailable;
    }

    public static class DriverBuilder {
        private String name;
        private String carModel;
        private String licenseNumber;
        private int experienceYears;
        private boolean isAvailable;

        public DriverBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DriverBuilder withCarModel(String carModel) {
            this.carModel = carModel;
            return this;
        }

        public DriverBuilder withLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
            return this;
        }

        public DriverBuilder withExperienceYears(int experienceYears) {
            this.experienceYears = experienceYears;
            return this;
        }

        public DriverBuilder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }

    @Override
    public String toString() {
        return "Driver [name=" + name + ", carModel=" + carModel + ", licenseNumber=" + licenseNumber +
                ", experienceYears=" + experienceYears + ", isAvailable=" + isAvailable + "]";
    }
}
