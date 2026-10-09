import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        // Rate for first 40 hours and 1.5 * rate for every hour above 40
        if (hours <= 40) {
            return hours * rate;
        }
        return (40 * rate) + ((hours - 40) * 1.5 * rate);
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void processPayroll(List<StaffMember> staffList) {
        double totalPayroll = 0.0;
        for (StaffMember staff : staffList) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", staff.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StaffMember> staffList = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                if (type.equalsIgnoreCase("FULLTIME")) {
                    double salary = sc.nextDouble();
                    staffList.add(new FullTimeStaff(name, salary));
                } else if (type.equalsIgnoreCase("HOURLY")) {
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staffList.add(new HourlyStaff(name, hours, rate));
                } else if (type.equalsIgnoreCase("INTERN")) {
                    double stipend = sc.nextDouble();
                    staffList.add(new InternStaff(name, stipend));
                }
            }
            processPayroll(staffList);
        } else {
            staffList.add(new FullTimeStaff("Asha", 12000));
            staffList.add(new HourlyStaff("Ravi", 45, 200));
            staffList.add(new InternStaff("Neha", 5000));
            processPayroll(staffList);
        }
        sc.close();
    }
}
