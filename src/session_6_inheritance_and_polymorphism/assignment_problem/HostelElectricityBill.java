import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract String getRoomType();
    public abstract double calculateBill();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        // 8 per unit
        return 8.0 * units;
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        // 6 per unit divided equally by occupants
        if (occupants <= 0) return 0.0;
        return (6.0 * units) / occupants;
    }
}

class AcRoom extends HostelRoom {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        // 10 per unit, plus fixed 200
        return (10.0 * units) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void displayBills(List<HostelRoom> rooms) {
        double grandTotal = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<HostelRoom> rooms = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int units = sc.nextInt();
                if (type.equalsIgnoreCase("SINGLE")) {
                    rooms.add(new SingleRoom(units));
                } else if (type.equalsIgnoreCase("SHARED")) {
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                } else if (type.equalsIgnoreCase("AC")) {
                    rooms.add(new AcRoom(units));
                }
            }
            displayBills(rooms);
        } else {
            rooms.add(new SingleRoom(120));
            rooms.add(new SharedRoom(150, 3));
            rooms.add(new AcRoom(100));
            displayBills(rooms);
        }
        sc.close();
    }
}
