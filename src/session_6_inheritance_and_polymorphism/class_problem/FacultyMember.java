public class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, String name, String department) {
        super(memberId, name);
        this.department = department;
    }

    @Override
    public void displayProfile() {
        System.out.printf("[%s] Faculty: %s (Dept: %s) | Books: %d%n",
                memberId, name, department, booksBorrowed);
    }
}
