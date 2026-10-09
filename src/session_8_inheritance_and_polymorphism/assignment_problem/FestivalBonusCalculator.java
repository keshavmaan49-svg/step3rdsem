import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class BonusEmployee {
    protected String name;
    protected double monthlySalary;

    public BonusEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends BonusEmployee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        // 10% of monthly salary
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends BonusEmployee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        // 5% of monthly salary
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends BonusEmployee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        // Fixed bonus of 2000
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void displayBonuses(List<BonusEmployee> employees) {
        double grandTotal = 0.0;
        for (BonusEmployee emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BonusEmployee> employees = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                double salary = sc.nextDouble();
                if (type.equalsIgnoreCase("FULLTIME")) {
                    employees.add(new FullTimeEmployee(name, salary));
                } else if (type.equalsIgnoreCase("PARTTIME")) {
                    employees.add(new PartTimeEmployee(name, salary));
                } else if (type.equalsIgnoreCase("INTERN")) {
                    employees.add(new InternEmployee(name, salary));
                }
            }
            displayBonuses(employees);
        } else {
            employees.add(new FullTimeEmployee("Asha", 50000));
            employees.add(new PartTimeEmployee("Ravi", 30000));
            employees.add(new InternEmployee("Neha", 15000));
            displayBonuses(employees);
        }
        sc.close();
    }
}
