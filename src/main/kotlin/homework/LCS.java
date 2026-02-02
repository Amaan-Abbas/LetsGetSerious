package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCS {
    public static int lcs(int[] nums1, int n, int[] nums2, int m, List<Integer> ch) {

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (nums1[i - 1] == nums2[j - 1]) {
                ch.add(0, nums1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];

        for(int i = 0; i < n; i++) nums1[i] = sc.nextInt();
        for(int j = 0; j < m; j++) nums2[j] = sc.nextInt();

        List<Integer> ans = new ArrayList<>();

        int res = lcs(nums1, n, nums2, m, ans);
        System.out.println(res);

        for(int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                System.out.print(ans.get(i));
                break;
            }

            System.out.print(ans.get(i) + " ");
        }
    }
}
