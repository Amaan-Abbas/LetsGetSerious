package homework;

import java.util.Arrays;
import java.util.Scanner;

public class NoOfPairs {
    public static int countPairs(Long[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int count = 0;

        while (start < end) {
            if (arr[start] + arr[end] <= target) {
                count += (end - start);
                start++;
            }
            else end--;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            Long[] nums = new Long[m];

            for (int j = 0; j < m; j++) nums[j] = sc.nextLong();
            Arrays.sort(nums);

            System.out.println(countPairs(nums, r) - countPairs(nums, l - 1));
        }
    }
}
