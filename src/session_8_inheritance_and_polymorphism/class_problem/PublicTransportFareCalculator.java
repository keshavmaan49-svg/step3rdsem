import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract String getTransportType();
    public abstract double calculateFare();
}

class BusTransport extends TransportJourney {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        // Base fare $2, plus $0.10 per km. Max fare $10.
        return Math.min(10.0, 2.0 + (0.10 * distance));
    }
}

class TrainTransport extends TransportJourney {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        // Base fare $3, plus $0.15 per km.
        return 3.0 + (0.15 * distance);
    }
}

class MetroTransport extends TransportJourney {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        // Base fare $1.50, plus $0.20 per km, multiplied by PeakHourFactor.
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void processJourneys(List<TransportJourney> journeys) {
        double grandTotal = 0.0;
        for (TransportJourney j : journeys) {
            double fare = j.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f%n", j.getTransportType(), fare);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TransportJourney> journeys = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double distance = sc.nextDouble();
                if (type.equalsIgnoreCase("BUS")) {
                    journeys.add(new BusTransport(distance));
                } else if (type.equalsIgnoreCase("TRAIN")) {
                    journeys.add(new TrainTransport(distance));
                } else if (type.equalsIgnoreCase("METRO")) {
                    double peak = sc.nextDouble();
                    journeys.add(new MetroTransport(distance, peak));
                }
            }
            processJourneys(journeys);
        } else {
            journeys.add(new BusTransport(15));
            journeys.add(new TrainTransport(50));
            journeys.add(new MetroTransport(10, 1.5));
            processJourneys(journeys);
        }
        sc.close();
    }
}
