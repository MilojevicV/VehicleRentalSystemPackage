package VehicleRentalSystemPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void generateInvoice(String customerName, Vehicle vehicle, Date startDate, Date endDate,
            int actualRentalDays, double rentalCost, double insuranceCost) {
        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + dateFormat.format(new Date()));
        System.out.println("Customer Name: " + customerName);
        System.out.println("Rented Vehicle: " + vehicle.getVehicleBrand() + " " + vehicle.getVehicleModel());
        System.out.println("Reservation start date: " + dateFormat.format(startDate));
        System.out.println("Reservation end date: " + dateFormat.format(endDate));
        System.out.println(
                "Reserved rental days: " + (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) + " days");
        System.out.println("Actual return date: " + dateFormat.format(new Date()));
        System.out.println("Actual rental days: " + actualRentalDays + " days");
        System.out.println("Rental cost per day: $" + rentalCost / actualRentalDays);
        System.out.println("Insurance per day: $" + insuranceCost / actualRentalDays);
        System.out.println("Total rent: $" + rentalCost);
        System.out.println("Total Insurance: $" + insuranceCost);
        System.out.println("Total: $" + (rentalCost + insuranceCost));
        System.out.println("XXXXXXXXXX");
    }

}