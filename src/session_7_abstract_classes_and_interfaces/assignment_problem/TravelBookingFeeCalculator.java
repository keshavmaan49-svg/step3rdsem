import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;
    public static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();
    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "BUS";
    }

    @Override
    public double calculateBaseFare() {
        // 2 per km
        return 2.0 * distanceKm;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }

    @Override
    public double calculateBaseFare() {
        // 1.5 per km
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }

    @Override
    public double calculateBaseFare() {
        // 2500 plus 4 per km
        return 2500.0 + (4.0 * distanceKm);
    }
}

public class TravelBookingFeeCalculator {
    public static void displayBookings(List<TravelBooking> bookings) {
        for (TravelBooking b : bookings) {
            double total = b.calculateTotalFare();
            System.out.printf("%s: %.2f%n", b.getMode(), total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TravelBooking> bookings = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String mode = sc.next();
                double dist = sc.nextDouble();
                if (mode.equalsIgnoreCase("BUS")) {
                    bookings.add(new BusBooking(dist));
                } else if (mode.equalsIgnoreCase("TRAIN")) {
                    bookings.add(new TrainBooking(dist));
                } else if (mode.equalsIgnoreCase("FLIGHT")) {
                    bookings.add(new FlightBooking(dist));
                }
            }
            displayBookings(bookings);
        } else {
            bookings.add(new BusBooking(200));
            bookings.add(new TrainBooking(300));
            bookings.add(new FlightBooking(500));
            displayBookings(bookings);
        }
        sc.close();
    }
}
