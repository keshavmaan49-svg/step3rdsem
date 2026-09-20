public class IsbnValidator {
    static String normalizeCode(String raw) {
        raw = raw.trim();
        return raw.substring(0, 3).toUpperCase() + raw.substring(3);
    }
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);
        return "[PUB]".replace("PUB", publisher) + " YEAR: " + year + " | CATALOG: " + catalog;
    }
    public static void main(String[] args) {
        String raw = "pen2026004251 ";
        String code = normalizeCode(raw);
        System.out.println(validateAndFormat(code));
    }
}