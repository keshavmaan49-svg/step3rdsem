public class PremiumMember extends GymMember {
    private double personalTrainerFee;

    public PremiumMember(String memberId, String name, double baseFee, double personalTrainerFee) {
        super(memberId, name, baseFee);
        this.personalTrainerFee = personalTrainerFee;
    }

    @Override
    public double calculateFee(int sessionsAttended) {
        return baseFee + personalTrainerFee;
    }

    @Override
    public void displayMemberInfo() {
        System.out.printf("[%s] Premium Member: %s | Base Fee: $%.2f | Trainer Fee: $%.2f | Total: $%.2f%n",
                memberId, name, baseFee, personalTrainerFee, calculateFee(0));
    }
}
