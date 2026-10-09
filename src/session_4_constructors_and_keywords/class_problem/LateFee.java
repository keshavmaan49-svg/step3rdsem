public class LateFee {
    private double dailyRate;

    public LateFee(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public final double calculateLateFee(int daysOverdue) {
        if (daysOverdue <= 0) return 0.0;
        return daysOverdue * dailyRate;
    }

    public final void printSummary(String studentName, int daysOverdue) {
        double fee = calculateLateFee(daysOverdue);
        System.out.printf("Student: %s | Days Overdue: %d | Late Fee: $%.2f%n",
                studentName, daysOverdue, fee);
    }

    public static void main(String[] args) {
        LateFee feeCalculator = new LateFee(5.0);
        feeCalculator.printSummary("Keshav", 4);
        feeCalculator.printSummary("Ananya", 0);
    }
}
