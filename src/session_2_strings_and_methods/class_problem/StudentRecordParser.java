public class StudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.printf("Input: \"%s\" -> Invalid Record%n", csvLine);
            return;
        }

        String name = parts[0].trim();
        String rollNo = parts[1].trim();
        String dept = parts[2].trim();

        System.out.printf("Input: \"%s\"%n  -> Name: %s | Roll No: %s | Dept: %s%n", csvLine, name, rollNo, dept);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
        parseStudentRecord("Keshav Maan,RA2211003010456,IT");
    }
}
