import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightServiceAvailable {
    default double calculateNightFare(double baseFare) {
        return baseFare * 1.20;
    }
}

abstract class CityCab {
    protected double km;
    protected String time;

    public CityCab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract String getCabType();
    public abstract double getRatePerKm();

    public boolean isNightTrip() {
        return "NIGHT".equalsIgnoreCase(time);
    }

    public double calculateTripFare() {
        double rawFare = km * getRatePerKm();
        double baseFare = Math.max(100.0, rawFare);

        if (isNightTrip()) {
            if (this instanceof NightServiceAvailable) {
                return ((NightServiceAvailable) this).calculateNightFare(baseFare);
            } else {
                return -1.0; // Rejected
            }
        }
        return baseFare;
    }
}

class MiniCab extends CityCab {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    public String getCabType() {
        return "MINI";
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends CityCab implements NightServiceAvailable {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    public String getCabType() {
        return "SEDAN";
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SuvCab extends CityCab implements NightServiceAvailable {
    public SuvCab(double km, String time) {
        super(km, time);
    }

    @Override
    public String getCabType() {
        return "SUV";
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void processTrips(List<CityCab> cabs) {
        double grandTotal = 0.0;
        for (CityCab cab : cabs) {
            double fare = cab.calculateTripFare();
            if (fare < 0) {
                System.out.printf("%s: night service not available%n", cab.getCabType());
            } else {
                grandTotal += fare;
                System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CityCab> cabs = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double km = sc.nextDouble();
                String time = sc.next();
                if (type.equalsIgnoreCase("MINI")) {
                    cabs.add(new MiniCab(km, time));
                } else if (type.equalsIgnoreCase("SEDAN")) {
                    cabs.add(new SedanCab(km, time));
                } else if (type.equalsIgnoreCase("SUV")) {
                    cabs.add(new SuvCab(km, time));
                }
            }
            processTrips(cabs);
        } else {
            cabs.add(new MiniCab(8, "DAY"));
            cabs.add(new SedanCab(10, "NIGHT"));
            cabs.add(new SuvCab(20, "DAY"));
            cabs.add(new MiniCab(5, "NIGHT"));
            processTrips(cabs);
        }
        sc.close();
    }
}
