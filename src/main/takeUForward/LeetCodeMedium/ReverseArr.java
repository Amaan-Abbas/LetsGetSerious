package LeetCodeMedium;

import java.util.Arrays;

public class ReverseArr {
    public void rotate(int[] nums, int k) {
        int n = nums.length - 1;


        int start = 0;
        int end = n - k;

        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }

        start = n - k + 1;
        end = n;

        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }

        start = 0;
        end = n;

        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        ReverseArr ob = new ReverseArr();

        int[] arr = {-1};
        ob.rotate(arr, 2);

        System.out.println(Arrays.toString(arr));
    }
}
