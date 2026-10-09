import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusUser {
    default double getTransportFee() {
        return 12000.0;
    }
}

abstract class StudentFeeRecord {
    protected String name;

    public StudentFeeRecord(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTotalFee();
}

class DayScholarStudent extends StudentFeeRecord implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTotalFee() {
        // Tuition 40000 + Transport fee 12000
        return 40000.0 + getTransportFee();
    }
}

class HostellerStudent extends StudentFeeRecord {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTotalFee() {
        // Tuition 40000 plus hostel fee 60000
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends StudentFeeRecord implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTotalFee() {
        // Half tuition (20000) + Transport fee 12000
        return 20000.0 + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void displayReport(List<StudentFeeRecord> students) {
        double grandTotal = 0.0;
        for (StudentFeeRecord s : students) {
            double fee = s.calculateTotalFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StudentFeeRecord> students = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                    students.add(new DayScholarStudent(name));
                } else if (type.equalsIgnoreCase("HOSTELLER")) {
                    students.add(new HostellerStudent(name));
                } else if (type.equalsIgnoreCase("SCHOLAR")) {
                    students.add(new ScholarshipStudent(name));
                }
            }
            displayReport(students);
        } else {
            students.add(new DayScholarStudent("Asha"));
            students.add(new HostellerStudent("Ravi"));
            students.add(new ScholarshipStudent("Neha"));
            displayReport(students);
        }
        sc.close();
    }
}
