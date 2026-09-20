public class MovieBookingProfile {
    private String username;
    private String email;
    private String membershipTier;
    private String writeOnlyOtp;

    public MovieBookingProfile(String username, String email, String membershipTier) {
        this.username = username;
        this.email = email;
        this.membershipTier = membershipTier;
    }

    public MovieBookingProfile(String username, String email) {
        this(username, email, "STANDARD");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(String membershipTier) {
        this.membershipTier = membershipTier;
    }

    public void setOtp(String otp) {
        this.writeOnlyOtp = otp;
        System.out.println("OTP updated securely (Write-Only).");
    }

    public boolean verifyOtp(String inputOtp) {
        return this.writeOnlyOtp != null && this.writeOnlyOtp.equals(inputOtp);
    }

    public static void main(String[] args) {
        MovieBookingProfile profile = new MovieBookingProfile("keshav49", "keshav@example.com");
        profile.setOtp("492810");
        System.out.println("User: " + profile.getUsername() + " | Tier: " + profile.getMembershipTier());
        System.out.println("OTP Verification: " + profile.verifyOtp("492810"));
    }
}
