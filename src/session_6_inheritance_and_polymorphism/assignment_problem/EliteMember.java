public class EliteMember extends PremiumMember {
    private String dedicatedLockerId;

    public EliteMember(String memberId, String name, double baseFee, double trainerFee, String lockerId) {
        super(memberId, name, baseFee, trainerFee);
        this.dedicatedLockerId = lockerId;
    }

    @Override
    public void displayMemberInfo() {
        super.displayMemberInfo();
        System.out.printf("   -> Allocated Locker: %s [All-Access VIP Pass]%n", dedicatedLockerId);
    }
}
