import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class VehicleParking {
    protected int hours;

    public VehicleParking(int hours) {
        this.hours = hours;
    }

    public abstract String getVehicleType();
    public abstract double calculateCharge();
}

class BikeParking extends VehicleParking {
    public BikeParking(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        // 10 per hour
        return 10.0 * hours;
    }
}

class CarParking extends VehicleParking {
    public CarParking(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        // 30 for first hour, plus 20 for each additional hour
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class TruckParking extends VehicleParking {
    public TruckParking(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        // 50 per hour, minimum 100
        return Math.max(100.0, 50.0 * hours);
    }
}

public class CampusParkingChargeCalculator {
    public static void displayReport(List<VehicleParking> vehicles) {
        double grandTotal = 0.0;
        for (VehicleParking v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", v.getVehicleType(), charge);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<VehicleParking> vehicles = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int hours = sc.nextInt();
                if (type.equalsIgnoreCase("BIKE")) {
                    vehicles.add(new BikeParking(hours));
                } else if (type.equalsIgnoreCase("CAR")) {
                    vehicles.add(new CarParking(hours));
                } else if (type.equalsIgnoreCase("TRUCK")) {
                    vehicles.add(new TruckParking(hours));
                }
            }
            displayReport(vehicles);
        } else {
            vehicles.add(new BikeParking(3));
            vehicles.add(new CarParking(4));
            vehicles.add(new TruckParking(1));
            vehicles.add(new CarParking(1));
            displayReport(vehicles);
        }
        sc.close();
    }
}
