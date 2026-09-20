public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printDetails() {
        System.out.printf("ID: %d | Name: %s | Salary: $%.2f%n", this.id, this.name, this.salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "Keshav", 75000.0);
        emp.printDetails();
        emp.raiseSalary(5000.0);
        System.out.println("After Salary Raise:");
        emp.printDetails();
    }
}
