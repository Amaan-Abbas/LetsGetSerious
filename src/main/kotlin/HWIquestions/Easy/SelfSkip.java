package HWIquestions.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class SelfSkip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();

        int[] dp = new int[size];
        Arrays.fill(dp, -1);

        System.out.println(helper(arr, 0, dp));
    }

    public static int helper(int[] arr, int idx, int[] dp) {

        if (idx >= arr.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        int notTake = helper(arr, idx + 1, dp);

        int take = arr[idx] + helper(arr, idx + arr[idx] + 1, dp);

        return dp[idx] = Math.max(notTake, take);
    }
}
