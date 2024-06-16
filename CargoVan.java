package VehicleRentalSystemPackage;

class CargoVan extends Vehicle {
    private int driverExperience;

    public CargoVan(String brand, String model, double value, int driverExperience) {
        super(brand, model, value);
        this.driverExperience = driverExperience;
    }

    public int getDriverExperience() {
        return driverExperience;
    }
}
