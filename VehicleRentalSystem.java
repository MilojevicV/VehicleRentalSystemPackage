package VehicleRentalSystemPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class VehicleRentalSystem {
        public static void main(String[] args) throws Exception {
                // Create sample vehicles
                Car car = new Car("Mitsubishi", "Mirage", 15000.00, 3);
                Motorcycle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000.00, 20);
                CargoVan cargoVan = new CargoVan("Citroen", "Jumper", 20000.00, 8);

                // Set rental parameters
                String customerName = "John Doe";
                Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-03");
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-13");

                // Calculate the set rental days
                long timeDiff = endDate.getTime() - startDate.getTime();
                int rentalPeriod = Math.toIntExact(TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS));

                // Calculate the actual rental days
                long diff = new Date().getTime() - startDate.getTime();
                int actualRentalDays = Math.toIntExact(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

                // Calculate rental and insurance costs
                Rental rental = new Rental();
                double carRentalCost = rental.calculateRentalCost(car, rentalPeriod, actualRentalDays);
                double carInsuranceCost = rental.calculateInsuranceCost(car, rentalPeriod, actualRentalDays);
                double motorcycleRentalCost = rental.calculateRentalCost(motorcycle, rentalPeriod, actualRentalDays);
                double motorcycleInsuranceCost = rental.calculateInsuranceCost(motorcycle, rentalPeriod,
                                actualRentalDays);
                double cargoVanRentalCost = rental.calculateRentalCost(cargoVan, rentalPeriod, actualRentalDays);
                double cargoVanInsuranceCost = rental.calculateInsuranceCost(cargoVan, rentalPeriod, actualRentalDays);

                // Generate and print invoices
                Invoice invoice = new Invoice();
                invoice.generateInvoice(customerName, car, startDate, endDate, actualRentalDays, carRentalCost,
                                carInsuranceCost);
                invoice.generateInvoice(customerName, motorcycle, startDate, endDate, actualRentalDays,
                                motorcycleRentalCost,
                                motorcycleInsuranceCost);
                invoice.generateInvoice(customerName, cargoVan, startDate, endDate, actualRentalDays,
                                cargoVanRentalCost,
                                cargoVanInsuranceCost);
        }
}