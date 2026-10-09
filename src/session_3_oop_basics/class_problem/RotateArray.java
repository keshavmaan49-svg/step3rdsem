import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        k = k % n;
        if (k == 0) return nums.clone();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        return result;
    }

    public static void test(int[] nums, int k) {
        int[] rotated = rotateArray(nums, k);
        System.out.printf("nums = %s, k = %d -> Rotated: %s%n",
                Arrays.toString(nums), k, Arrays.toString(rotated));
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        test(new int[]{1, 2}, 3);
        test(new int[]{-1, -100, 3, 99}, 2);
    }
}
