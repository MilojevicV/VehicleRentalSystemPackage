package VehicleRentalSystemPackage;

import java.text.DecimalFormat;

class Rental {
    private static final double CAR_RENTAL_COST_SHORT = 20.0;
    private static final double CAR_RENTAL_COST_LONG = 15.0;
    private static final double MOTORCYCLE_RENTAL_COST_SHORT = 15.0;
    private static final double MOTORCYCLE_RENTAL_COST_LONG = 10.0;
    private static final double CARGO_VAN_RENTAL_COST_SHORT = 50.0;
    private static final double CARGO_VAN_RENTAL_COST_LONG = 40.0;
    private static final double CAR_INSURANCE_RATE = 0.0001;
    private static final double MOTORCYCLE_INSURANCE_RATE = 0.0002;
    private static final double CARGO_VAN_INSURANCE_RATE = 0.0003;
    private static final double INSURANCE_DISCOUNT_CAR = 0.1;
    private static final double INSURANCE_INCREASE_MOTORCYCLE = 0.2;
    private static final double INSURANCE_DISCOUNT_CARGO_VAN = 0.15;

    private DecimalFormat df = new DecimalFormat("0.00");

    // Calculate rental cost based on vehicle type and rental period
    public double calculateRentalCost(Vehicle vehicle, int rentalPeriod, int actualRentalDays) {
        double rentalCost;

        if (!(vehicle instanceof Car || vehicle instanceof Motorcycle || vehicle instanceof CargoVan)) {
            throw new IllegalArgumentException(
                    "Invalid vehicle type. Rental cost calculation only supports Car, Motorcycle, or CargoVan.");
        }

        if (rentalPeriod <= 7) {
            if (vehicle instanceof Car)
                rentalCost = CAR_RENTAL_COST_SHORT;
            else if (vehicle instanceof Motorcycle)
                rentalCost = MOTORCYCLE_RENTAL_COST_SHORT;
            else // CargoVan
                rentalCost = CARGO_VAN_RENTAL_COST_SHORT;
        } else {
            if (vehicle instanceof Car)
                rentalCost = CAR_RENTAL_COST_LONG;
            else if (vehicle instanceof Motorcycle)
                rentalCost = MOTORCYCLE_RENTAL_COST_LONG;
            else // CargoVan
                rentalCost = CARGO_VAN_RENTAL_COST_LONG;
        }

        double totalRentalCost = rentalCost * actualRentalDays;

        // Adjust rental cost for early return
        if (actualRentalDays < rentalPeriod) {
            totalRentalCost = totalRentalCost - ((rentalPeriod - actualRentalDays) * rentalCost / 2);
        }

        return totalRentalCost;
    }

    // Calculate insurance cost based on vehicle type, value, and additional factors
    public double calculateInsuranceCost(Vehicle vehicle, int rentalPeriod, int actualRentalDays) {
        double insuranceRate;

        if (!(vehicle instanceof Car || vehicle instanceof Motorcycle || vehicle instanceof CargoVan)) {
            throw new IllegalArgumentException(
                    "Invalid vehicle type. Insurance cost calculation only supports Car, Motorcycle, or CargoVan.");
        }

        if (vehicle instanceof Car)
            insuranceRate = CAR_INSURANCE_RATE;
        else if (vehicle instanceof Motorcycle)
            insuranceRate = MOTORCYCLE_INSURANCE_RATE;
        else // CargoVan
            insuranceRate = CARGO_VAN_INSURANCE_RATE;

        double insuranceCost = vehicle.getVehicleValue() * insuranceRate * rentalPeriod;

        // Apply discounts or increases based on additional factors
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            if (car.getSafetyRating() >= 4)
                insuranceCost *= (1 - INSURANCE_DISCOUNT_CAR);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            if (motorcycle.getRiderAge() < 25)
                insuranceCost *= (1 + INSURANCE_INCREASE_MOTORCYCLE);
        } else { // CargoVan
            CargoVan cargoVan = (CargoVan) vehicle;
            if (cargoVan.getDriverExperience() > 5)
                insuranceCost *= (1 - INSURANCE_DISCOUNT_CARGO_VAN);
        }

        // Adjust insurance cost for early return
        if (actualRentalDays < rentalPeriod) {
            insuranceCost = insuranceCost
                    - (vehicle.getVehicleValue() * insuranceRate * (rentalPeriod - actualRentalDays));
        }

        return Double.parseDouble(df.format(insuranceCost));
    }
}
