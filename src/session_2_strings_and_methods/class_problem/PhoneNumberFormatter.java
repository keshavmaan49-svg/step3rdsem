public class PhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-");
        sb.append(phone.substring(6));

        return sb.toString();
    }

    public static void checkPhone(String phone) {
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone, maskPhoneNumber(phone));
    }

    public static void main(String[] args) {
        checkPhone("9876543210");
        checkPhone("98765");
        checkPhone("98765A3210");
        checkPhone("9123456789");
    }
}
