import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicSubscriptionPlan extends SubscriptionPlan {
    public BasicSubscriptionPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardSubscriptionPlan extends SubscriptionPlan {
    public StandardSubscriptionPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumSubscriptionPlan extends SubscriptionPlan {
    public PremiumSubscriptionPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void displayRenewals(List<SubscriptionPlan> subscriptions) {
        for (SubscriptionPlan sub : subscriptions) {
            LocalDate renewal = sub.calculateRenewalDate();
            System.out.printf("%s: %s%n", sub.getName(), renewal.format(FORMATTER));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SubscriptionPlan> subscriptions = new ArrayList<>();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                String dateStr = sc.next();
                LocalDate date = LocalDate.parse(dateStr, FORMATTER);

                if (type.equalsIgnoreCase("BASIC")) {
                    subscriptions.add(new BasicSubscriptionPlan(name, date));
                } else if (type.equalsIgnoreCase("STANDARD")) {
                    subscriptions.add(new StandardSubscriptionPlan(name, date));
                } else if (type.equalsIgnoreCase("PREMIUM")) {
                    subscriptions.add(new PremiumSubscriptionPlan(name, date));
                }
            }
            displayRenewals(subscriptions);
        } else {
            subscriptions.add(new BasicSubscriptionPlan("Asha", LocalDate.parse("2024-01-15", FORMATTER)));
            subscriptions.add(new StandardSubscriptionPlan("Ravi", LocalDate.parse("2024-02-01", FORMATTER)));
            subscriptions.add(new PremiumSubscriptionPlan("Neha", LocalDate.parse("2024-03-10", FORMATTER)));
            subscriptions.add(new BasicSubscriptionPlan("Kiran", LocalDate.parse("2024-12-20", FORMATTER)));
            displayRenewals(subscriptions);
        }
        sc.close();
    }
}
