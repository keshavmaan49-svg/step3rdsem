import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class CustomerBill {
    protected double amount;

    public CustomerBill(double amount) {
        this.amount = amount;
    }

    public abstract String getCustomerType();
    public abstract double calculateFinalAmount();
}

class StudentCustomerBill extends CustomerBill {
    public StudentCustomerBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }

    @Override
    public double calculateFinalAmount() {
        // Students get a 10% discount
        return amount * 0.90;
    }
}

class StaffCustomerBill extends CustomerBill {
    public StaffCustomerBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }

    @Override
    public double calculateFinalAmount() {
        // Staff get a 5% discount
        return amount * 0.95;
    }
}

class GuestCustomerBill extends CustomerBill {
    public GuestCustomerBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }

    @Override
    public double calculateFinalAmount() {
        // Guests pay full amount plus 10 service charge
        return amount + 10.0;
    }
}

public class CanteenBillingCounter {
    public static void generateReport(List<CustomerBill> bills) {
        double grandTotal = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmt = bill.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmt);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CustomerBill> bills = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();
                if (type.equalsIgnoreCase("STUDENT")) {
                    bills.add(new StudentCustomerBill(amount));
                } else if (type.equalsIgnoreCase("STAFF")) {
                    bills.add(new StaffCustomerBill(amount));
                } else if (type.equalsIgnoreCase("GUEST")) {
                    bills.add(new GuestCustomerBill(amount));
                }
            }
            generateReport(bills);
        } else {
            bills.add(new StudentCustomerBill(200));
            bills.add(new StaffCustomerBill(300));
            bills.add(new GuestCustomerBill(150));
            generateReport(bills);
        }
        sc.close();
    }
}
