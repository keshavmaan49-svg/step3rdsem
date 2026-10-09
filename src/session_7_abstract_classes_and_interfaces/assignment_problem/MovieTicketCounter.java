import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class CinemaSeatTicket {
    protected int count;
    public static final double CONVENIENCE_FEE = 20.0;

    public CinemaSeatTicket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();
    public abstract double getBasePrice();

    public double calculateTotalAmount() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularSeatTicket extends CinemaSeatTicket {
    public RegularSeatTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumSeatTicket extends CinemaSeatTicket {
    public PremiumSeatTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerSeatTicket extends CinemaSeatTicket {
    public ReclinerSeatTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void displayBookings(List<CinemaSeatTicket> bookings) {
        double grandTotal = 0.0;
        for (CinemaSeatTicket ticket : bookings) {
            double amount = ticket.calculateTotalAmount();
            grandTotal += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CinemaSeatTicket> bookings = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int count = sc.nextInt();
                if (type.equalsIgnoreCase("REGULAR")) {
                    bookings.add(new RegularSeatTicket(count));
                } else if (type.equalsIgnoreCase("PREMIUM")) {
                    bookings.add(new PremiumSeatTicket(count));
                } else if (type.equalsIgnoreCase("RECLINER")) {
                    bookings.add(new ReclinerSeatTicket(count));
                }
            }
            displayBookings(bookings);
        } else {
            bookings.add(new RegularSeatTicket(3));
            bookings.add(new PremiumSeatTicket(2));
            bookings.add(new ReclinerSeatTicket(1));
            displayBookings(bookings);
        }
        sc.close();
    }
}
