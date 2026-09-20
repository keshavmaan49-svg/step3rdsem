public class Student {
    private String name;
    private double attendance;
    public static String collegeName = "SRM Institute of Science and Technology";
    public static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Keshav", 88.5);
        Student s2 = new Student("Ananya", 92.0);

        Student.printCollegeInfo();
    }
}
