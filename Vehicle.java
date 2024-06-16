package VehicleRentalSystemPackage;

class Vehicle {
    protected String brand;
    protected String model;
    protected double value;

    public Vehicle(String brand, String model, double value) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }

    public String getVehicleBrand() {
        return brand;
    }

    public String getVehicleModel() {
        return model;
    }

    public double getVehicleValue() {
        return value;
    }
}
