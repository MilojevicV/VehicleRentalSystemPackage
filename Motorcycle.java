package VehicleRentalSystemPackage;

class Motorcycle extends Vehicle {
    private int riderAge;

    public Motorcycle(String brand, String model, double value, int riderAge) {
        super(brand, model, value);
        this.riderAge = riderAge;
    }

    public int getRiderAge() {
        return riderAge;
    }
}
