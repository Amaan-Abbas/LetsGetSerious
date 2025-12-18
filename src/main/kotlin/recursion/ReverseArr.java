package recursion;

import java.util.Arrays;

public class ReverseArr {
    public static void reverse(int i, int j, int[] arr) {
        if ( i >= j) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(i + 1, j - 1, arr);
    }

    public static void switchArr(int i, int[] nums) {
        if (i >= nums.length / 2) return;

        int temp = nums[i];
        nums[i] = nums[nums.length - i - 1];
        nums[nums.length - i - 1] = temp;

        switchArr(i + 1, nums);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverse(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));

        switchArr(0, arr);
        System.out.println(Arrays.toString(arr));
    }
}
