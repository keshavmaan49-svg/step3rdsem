import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface InsurableParcel {
    double calculateInsurance();
}

abstract class ShippingParcel {
    protected double weightKg;
    protected double declaredValue;

    public ShippingParcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract String getParcelType();
    public abstract double calculateShippingCharge();

    public double getInsuranceAmount() {
        if (this instanceof InsurableParcel) {
            return ((InsurableParcel) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsuranceAmount();
    }
}

class StandardShippingParcel extends ShippingParcel {
    public StandardShippingParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getParcelType() {
        return "STANDARD";
    }

    @Override
    public double calculateShippingCharge() {
        // 40 plus 10 per kg
        return 40.0 + (10.0 * weightKg);
    }
}

class ExpressShippingParcel extends ShippingParcel implements InsurableParcel {
    public ExpressShippingParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getParcelType() {
        return "EXPRESS";
    }

    @Override
    public double calculateShippingCharge() {
        // 80 plus 15 per kg
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        // 2% of declared value
        return 0.02 * declaredValue;
    }
}

class FragileShippingParcel extends ShippingParcel implements InsurableParcel {
    public FragileShippingParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getParcelType() {
        return "FRAGILE";
    }

    @Override
    public double calculateShippingCharge() {
        // standard charge (40 + 10*w) plus handling fee of 50
        return (40.0 + (10.0 * weightKg)) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        // 2% of declared value
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {
    public static void displayParcels(List<ShippingParcel> parcels) {
        double grandTotal = 0.0;
        for (ShippingParcel p : parcels) {
            double charge = p.calculateShippingCharge();
            double insurance = p.getInsuranceAmount();
            double total = p.calculateTotal();
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getParcelType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ShippingParcel> parcels = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double weight = sc.nextDouble();
                double val = sc.nextDouble();
                if (type.equalsIgnoreCase("STANDARD")) {
                    parcels.add(new StandardShippingParcel(weight, val));
                } else if (type.equalsIgnoreCase("EXPRESS")) {
                    parcels.add(new ExpressShippingParcel(weight, val));
                } else if (type.equalsIgnoreCase("FRAGILE")) {
                    parcels.add(new FragileShippingParcel(weight, val));
                }
            }
            displayParcels(parcels);
        } else {
            parcels.add(new StandardShippingParcel(3, 500));
            parcels.add(new ExpressShippingParcel(2, 1000));
            parcels.add(new FragileShippingParcel(4, 2000));
            displayParcels(parcels);
        }
        sc.close();
    }
}
