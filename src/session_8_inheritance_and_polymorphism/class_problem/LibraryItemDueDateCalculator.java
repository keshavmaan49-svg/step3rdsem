import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getBorrowingDays();

    public LocalDate calculateDueDate(LocalDate fromDate) {
        return fromDate.plusDays(getBorrowingDays());
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

public class LibraryItemDueDateCalculator {
    public static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void displayDueDates(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(CURRENT_DATE);
            System.out.printf("%s: %s%n", item.getTitle(), dueDate.format(FORMATTER));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<LibraryItem> items = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                String type = line.substring(0, line.indexOf(" "));
                String title = line.substring(line.indexOf(" ") + 1).replace("\"", "");

                if (type.equalsIgnoreCase("BOOK")) {
                    items.add(new BookItem(title));
                } else if (type.equalsIgnoreCase("DVD")) {
                    items.add(new DvdItem(title));
                } else if (type.equalsIgnoreCase("MAGAZINE")) {
                    items.add(new MagazineItem(title));
                }
            }
            displayDueDates(items);
        } else {
            items.add(new BookItem("1984"));
            items.add(new DvdItem("The Matrix"));
            items.add(new MagazineItem("Forbes Issue 500"));
            displayDueDates(items);
        }
        sc.close();
    }
}
