public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void displayReversal(String name) {
        String reversed = reverseCustomerName(name);
        System.out.printf("Original Name: %s | Reversed Name: %s%n", name, reversed);
    }

    public static void main(String[] args) {
        displayReversal("Sunil");
        displayReversal("Keshav");
        displayReversal("Ananya");
    }
}
