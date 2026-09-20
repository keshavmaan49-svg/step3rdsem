public class SrmStudent {
    public static String universityName;
    public static String accreditation;

    static {
        universityName = "SRM Institute of Science and Technology";
        accreditation = "NAAC A++";
        System.out.println("[Static Init Block] Initialized SRM University metadata.");
    }

    private String name;
    private String regNo;

    public SrmStudent(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
    }

    public void displayStudent() {
        System.out.printf("Student: %s (%s) | University: %s [%s]%n",
                name, regNo, universityName, accreditation);
    }

    public static void main(String[] args) {
        SrmStudent s1 = new SrmStudent("Keshav Maan", "RA2211003010123");
        s1.displayStudent();
    }
}
