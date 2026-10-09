public class GroupClassMember extends GymMember {
    private String groupClassName;
    private double groupClassFee;

    public GroupClassMember(String memberId, String name, double baseFee, String groupClassName, double groupClassFee) {
        super(memberId, name, baseFee);
        this.groupClassName = groupClassName;
        this.groupClassFee = groupClassFee;
    }

    @Override
    public double calculateFee(int sessionsAttended) {
        return baseFee + groupClassFee;
    }

    @Override
    public void displayMemberInfo() {
        System.out.printf("[%s] Group Class Member: %s | Class: %s | Total Fee: $%.2f%n",
                memberId, name, groupClassName, calculateFee(0));
    }
}
