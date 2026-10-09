import java.util.Arrays;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void test(int[] nums) {
        System.out.printf("nums = %s -> Contains Duplicate: %b%n",
                Arrays.toString(nums), containsDuplicate(nums));
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 1});
        test(new int[]{1, 2, 3, 4});
        test(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
    }
}
