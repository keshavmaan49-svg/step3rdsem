public class StudentMember extends LibraryMember {
    private String studentRollNo;

    public StudentMember(String memberId, String name, String studentRollNo) {
        super(memberId, name);
        this.studentRollNo = studentRollNo;
    }

    @Override
    public void displayProfile() {
        System.out.printf("[%s] Student: %s (Roll: %s) | Books: %d%n",
                memberId, name, studentRollNo, booksBorrowed);
    }
}
