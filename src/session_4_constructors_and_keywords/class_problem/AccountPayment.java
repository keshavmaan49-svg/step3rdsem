class FeeAccount {
    String accountHolder;
    double balanceDue;

    public FeeAccount(String accountHolder, double balanceDue) {
        this.accountHolder = accountHolder;
        this.balanceDue = balanceDue;
    }
}

class HostelFeeAccount extends FeeAccount {
    String roomNo;

    public HostelFeeAccount(String accountHolder, double balanceDue, String roomNo) {
        super(accountHolder, balanceDue);
        this.roomNo = roomNo;
    }
}

public class AccountPayment {
    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAcc = (HostelFeeAccount) account;
            hostelAcc.balanceDue -= amount;
            System.out.printf("Processed Hostel Fee Payment: $%.2f for %s (Room: %s). Remaining: $%.2f%n",
                    amount, hostelAcc.accountHolder, hostelAcc.roomNo, hostelAcc.balanceDue);
        } else if (account != null) {
            account.balanceDue -= amount;
            System.out.printf("Processed Tuition Fee Payment: $%.2f for %s. Remaining: $%.2f%n",
                    amount, account.accountHolder, account.balanceDue);
        }
    }

    public static void main(String[] args) {
        FeeAccount tuition = new FeeAccount("Keshav", 5000.0);
        HostelFeeAccount hostel = new HostelFeeAccount("Ravi", 3000.0, "B-304");

        processPayment(tuition, 2000.0);
        processPayment(hostel, 1500.0);
    }
}
