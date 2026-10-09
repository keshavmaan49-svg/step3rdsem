public class GymReport {
    public static void printSummary(GymMember[] members) {
        System.out.println("================ GYM MEMBERSHIP REPORT ================");
        double totalRevenue = 0.0;

        for (GymMember m : members) {
            m.displayMemberInfo();
            totalRevenue += m.calculateFee(0);
        }

        System.out.println("-------------------------------------------------------");
        System.out.printf("Total Projected Monthly Revenue: $%.2f%n", totalRevenue);
    }

    public static void main(String[] args) {
        GymMember g1 = new GymMember("GYM-101", "Keshav Maan", 50.0);
        PremiumMember p1 = new PremiumMember("GYM-102", "Ananya Verma", 50.0, 40.0);
        EliteMember e1 = new EliteMember("GYM-103", "Ravi Kumar", 50.0, 40.0, "LOCKER-A1");
        GroupClassMember gc1 = new GroupClassMember("GYM-104", "Neha Singh", 50.0, "CrossFit", 25.0);

        GymMember[] list = {g1, p1, e1, gc1};
        printSummary(list);
    }
}
