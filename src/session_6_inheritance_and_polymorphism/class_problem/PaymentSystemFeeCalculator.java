import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract String getPaymentType();
    public abstract double calculateAdjustedAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }

    @Override
    public double calculateAdjustedAmount() {
        // 2% processing fee
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }

    @Override
    public double calculateAdjustedAmount() {
        // 1% processing fee
        return amount * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }

    @Override
    public double calculateAdjustedAmount() {
        // No processing fee
        return amount;
    }
}

public class PaymentSystemFeeCalculator {
    public static void processPayments(List<PaymentMethod> payments) {
        double grandTotal = 0.0;
        for (PaymentMethod p : payments) {
            double adjusted = p.calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f%n", p.getPaymentType(), adjusted);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PaymentMethod> payments = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();
                if (type.equalsIgnoreCase("CARD")) {
                    payments.add(new CardPayment(amount));
                } else if (type.equalsIgnoreCase("WALLET")) {
                    payments.add(new WalletPayment(amount));
                } else if (type.equalsIgnoreCase("BANKTRANSFER")) {
                    payments.add(new BankTransferPayment(amount));
                }
            }
            processPayments(payments);
        } else {
            // Demo with sample input
            payments.add(new CardPayment(1000));
            payments.add(new WalletPayment(500));
            payments.add(new BankTransferPayment(2000));
            processPayments(payments);
        }
        sc.close();
    }
}
