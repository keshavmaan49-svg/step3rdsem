public class GymMember {
    protected String memberId;
    protected String name;
    protected double baseFee;

    public GymMember(String memberId, String name, double baseFee) {
        this.memberId = memberId;
        this.name = name;
        this.baseFee = baseFee;
    }

    public double calculateFee(int sessionsAttended) {
        return baseFee;
    }

    public void displayMemberInfo() {
        System.out.printf("[%s] Member: %s | Base Fee: $%.2f%n", memberId, name, baseFee);
    }
}
