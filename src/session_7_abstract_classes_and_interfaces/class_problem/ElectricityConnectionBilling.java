import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PowerConnection {
    protected double units;

    public PowerConnection(double units) {
        this.units = units;
    }

    public abstract String getConnectionType();
    public abstract double calculateBill();
}

class HomeConnection extends PowerConnection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public String getConnectionType() {
        return "HOME";
    }

    @Override
    public double calculateBill() {
        // 5 per unit for first 100 units and 7 per unit after that
        if (units <= 100) {
            return units * 5.0;
        }
        return (100 * 5.0) + ((units - 100) * 7.0);
    }
}

class ShopConnection extends PowerConnection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public String getConnectionType() {
        return "SHOP";
    }

    @Override
    public double calculateBill() {
        // 8 per unit plus fixed charge of 100
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends PowerConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public String getConnectionType() {
        return "FACTORY";
    }

    @Override
    public double calculateBill() {
        // 6 per unit, with minimum bill of 1000
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void generateReport(List<PowerConnection> connections) {
        double grandTotal = 0.0;
        for (PowerConnection conn : connections) {
            double bill = conn.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", conn.getConnectionType(), bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PowerConnection> connections = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double units = sc.nextDouble();
                if (type.equalsIgnoreCase("HOME")) {
                    connections.add(new HomeConnection(units));
                } else if (type.equalsIgnoreCase("SHOP")) {
                    connections.add(new ShopConnection(units));
                } else if (type.equalsIgnoreCase("FACTORY")) {
                    connections.add(new FactoryConnection(units));
                }
            }
            generateReport(connections);
        } else {
            connections.add(new HomeConnection(150));
            connections.add(new ShopConnection(90));
            connections.add(new FactoryConnection(120));
            generateReport(connections);
        }
        sc.close();
    }
}
