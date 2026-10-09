import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void test(int[] nums, int target) {
        int[] result = twoSum(nums, target);
        System.out.printf("nums = %s, target = %d -> %s%n",
                Arrays.toString(nums), target, Arrays.toString(result));
    }

    public static void main(String[] args) {
        test(new int[]{2, 7, 11, 15}, 9);
        test(new int[]{3, 2, 4}, 6);
        test(new int[]{3, 3}, 6);
    }
}
