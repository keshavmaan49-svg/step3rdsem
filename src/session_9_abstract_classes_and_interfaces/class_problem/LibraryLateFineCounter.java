import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class BorrowedLibraryItem {
    protected String title;
    protected int daysLate;

    public BorrowedLibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookFineItem extends BorrowedLibraryItem {
    public BookFineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        // 2 per day late
        return 2.0 * daysLate;
    }
}

class DvdFineItem extends BorrowedLibraryItem {
    public DvdFineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        // 5 per day late, max 50
        return Math.min(50.0, 5.0 * daysLate);
    }
}

class MagazineFineItem extends BorrowedLibraryItem {
    public MagazineFineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        // 1 per day late
        return 1.0 * daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void displayFines(List<BorrowedLibraryItem> items) {
        double totalFines = 0.0;
        for (BorrowedLibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BorrowedLibraryItem> items = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String title = sc.next();
                int days = sc.nextInt();
                if (type.equalsIgnoreCase("BOOK")) {
                    items.add(new BookFineItem(title, days));
                } else if (type.equalsIgnoreCase("DVD")) {
                    items.add(new DvdFineItem(title, days));
                } else if (type.equalsIgnoreCase("MAGAZINE")) {
                    items.add(new MagazineFineItem(title, days));
                }
            }
            displayFines(items);
        } else {
            items.add(new BookFineItem("Algebra", 4));
            items.add(new DvdFineItem("Inception", 12));
            items.add(new MagazineFineItem("Sports", 3));
            displayFines(items);
        }
        sc.close();
    }
}
