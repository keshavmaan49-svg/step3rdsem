public class HonorsStudentMember extends StudentMember {
    private int researchBonusAllowance;

    public HonorsStudentMember(String memberId, String name, String studentRollNo, int bonusAllowance) {
        super(memberId, name, studentRollNo);
        this.researchBonusAllowance = bonusAllowance;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.printf("   -> Honors Research Allowance: +%d extra books%n", researchBonusAllowance);
    }
}
