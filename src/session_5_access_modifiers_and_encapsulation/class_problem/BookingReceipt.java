import java.util.Arrays;

public final class BookingReceipt {
    private final String receiptId;
    private final String customerName;
    private final double totalAmount;
    private final String[] seatNumbers;

    public BookingReceipt(String receiptId, String customerName, double totalAmount, String[] seatNumbers) {
        this.receiptId = receiptId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.seatNumbers = seatNumbers != null ? seatNumbers.clone() : new String[0];
    }

    public String getReceiptId() { return receiptId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public String[] getSeatNumbers() { return seatNumbers.clone(); }

    public BookingReceipt withCustomerName(String newCustomerName) {
        return new BookingReceipt(this.receiptId, newCustomerName, this.totalAmount, this.seatNumbers);
    }

    public void printReceipt() {
        System.out.printf("Receipt [%s] | Customer: %s | Amount: $%.2f | Seats: %s%n",
                receiptId, customerName, totalAmount, Arrays.toString(seatNumbers));
    }

    public static void main(String[] args) {
        BookingReceipt r1 = new BookingReceipt("REC-001", "Keshav", 45.0, new String[]{"A1", "A2", "A3"});
        r1.printReceipt();

        BookingReceipt r2 = r1.withCustomerName("Keshav Maan");
        r2.printReceipt();
    }
}
