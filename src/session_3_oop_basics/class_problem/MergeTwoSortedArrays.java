import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }

        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void test(int[] arr1, int[] arr2) {
        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.printf("arr1 = %s, arr2 = %s%n  -> Merged: %s%n",
                Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(merged));
    }

    public static void main(String[] args) {
        test(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        test(new int[]{}, new int[]{1, 2, 3});
        test(new int[]{1, 2, 8}, new int[]{3, 4, 5, 9});
    }
}
