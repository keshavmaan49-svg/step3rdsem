public class BankReferenceValidator {
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed.toUpperCase();
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length (must be 14 characters)";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        sb.append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void processCode(String raw) {
        String normalized = normalizeReference(raw);
        String formatted = validateAndFormat(normalized);
        System.out.printf("Raw Input: \"%s\"%n  -> Normalized: \"%s\"%n  -> Result: %s%n", raw, normalized, formatted);
    }

    public static void main(String[] args) {
        processCode(" hdf03022600042 ");
        processCode("12F03022600042");
        processCode("sbi15082612345");
        processCode("icici12345");
    }
}
