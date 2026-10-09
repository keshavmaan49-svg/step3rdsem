public class CirculationReport {
    public static void generateReport(LibraryMember[] members) {
        System.out.println("================ LIBRARY CIRCULATION REPORT ================");
        int totalBooks = 0;

        for (LibraryMember m : members) {
            m.displayProfile();
            totalBooks += m.getBooksBorrowed();

            if (m instanceof HonorsStudentMember) {
                System.out.println("   Classification: [Special Category - Honors Student]");
            } else if (m instanceof StudentMember) {
                System.out.println("   Classification: [Standard Student Member]");
            } else if (m instanceof FacultyMember) {
                System.out.println("   Classification: [Academic Faculty Member]");
            }
            System.out.println("------------------------------------------------------------");
        }

        System.out.println("Total Books in Circulation: " + totalBooks);
    }

    public static void main(String[] args) {
        StudentMember s1 = new StudentMember("LIB-001", "Keshav Maan", "RA2211003010123");
        s1.borrowBook();
        s1.borrowBook();

        HonorsStudentMember h1 = new HonorsStudentMember("LIB-002", "Ananya Verma", "RA2211003010456", 5);
        h1.borrowBook();
        h1.borrowBook();
        h1.borrowBook();

        FacultyMember f1 = new FacultyMember("LIB-003", "Dr. Sharma", "Computer Science");
        f1.borrowBook();

        LibraryMember[] list = {s1, h1, f1};
        generateReport(list);
    }
}
