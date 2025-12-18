package easy;

import java.awt.desktop.PreferencesEvent;
import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            } else {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        int i = removeDuplicates(nums);

        System.out.println(i);
    }
}
