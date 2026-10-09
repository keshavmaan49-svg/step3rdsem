import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverModeCapable {
    default double calculateSaverUnits(double standardUnits) {
        // Reduces energy use by 25%
        return standardUnits * 0.75;
    }
}

abstract class HomeAppliance {
    protected double hours;
    protected boolean isSaver;

    public HomeAppliance(double hours, boolean isSaver) {
        this.hours = hours;
        this.isSaver = isSaver;
    }

    public abstract String getApplianceName();
    public abstract double getPowerWatts();

    public boolean supportsSaverMode() {
        return this instanceof SaverModeCapable;
    }

    public double calculateUnits() {
        double standardUnits = (getPowerWatts() * hours) / 1000.0;
        if (isSaver) {
            if (supportsSaverMode()) {
                return ((SaverModeCapable) this).calculateSaverUnits(standardUnits);
            } else {
                return -1.0; // Not supported
            }
        }
        return standardUnits;
    }

    public double calculateCost() {
        double units = calculateUnits();
        if (units < 0) return -1.0;
        return units * 8.0;
    }
}

class FridgeAppliance extends HomeAppliance {
    public FridgeAppliance(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public String getApplianceName() {
        return "FRIDGE";
    }

    @Override
    public double getPowerWatts() {
        return 150.0;
    }
}

class AcAppliance extends HomeAppliance implements SaverModeCapable {
    public AcAppliance(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public String getApplianceName() {
        return "AC";
    }

    @Override
    public double getPowerWatts() {
        return 1500.0;
    }
}

class TvAppliance extends HomeAppliance {
    public TvAppliance(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public String getApplianceName() {
        return "TV";
    }

    @Override
    public double getPowerWatts() {
        return 100.0;
    }
}

class WasherAppliance extends HomeAppliance implements SaverModeCapable {
    public WasherAppliance(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public String getApplianceName() {
        return "WASHER";
    }

    @Override
    public double getPowerWatts() {
        return 500.0;
    }
}

public class HomeApplianceEnergyReport {
    public static void displayReport(List<HomeAppliance> appliances) {
        double totalCost = 0.0;
        for (HomeAppliance a : appliances) {
            double units = a.calculateUnits();
            double cost = a.calculateCost();

            if (units < 0) {
                System.out.printf("%s: saver mode not supported%n", a.getApplianceName());
            } else {
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.getApplianceName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<HomeAppliance> appliances = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double hours = sc.nextDouble();
                boolean saver = false;
                if (sc.hasNext("SAVER")) {
                    sc.next();
                    saver = true;
                }

                if (type.equalsIgnoreCase("FRIDGE")) {
                    appliances.add(new FridgeAppliance(hours, saver));
                } else if (type.equalsIgnoreCase("AC")) {
                    appliances.add(new AcAppliance(hours, saver));
                } else if (type.equalsIgnoreCase("TV")) {
                    appliances.add(new TvAppliance(hours, saver));
                } else if (type.equalsIgnoreCase("WASHER")) {
                    appliances.add(new WasherAppliance(hours, saver));
                }
            }
            displayReport(appliances);
        } else {
            appliances.add(new FridgeAppliance(24, false));
            appliances.add(new AcAppliance(8, true));
            appliances.add(new TvAppliance(5, false));
            appliances.add(new WasherAppliance(2, true));
            displayReport(appliances);
        }
        sc.close();
    }
}
