package homework;

import java.util.Scanner;

public class LuckyCS {
    public static String lcs(String str1, int n, String str2, int m, String str3, int l) {
        int[][][] dp = new int[n + 1][m + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) != str3.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j -1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }

        int i = n, j = m, k = l;
        StringBuilder str = new StringBuilder();
        while (i > 0 && j > 0 & k > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) != str3.charAt(k - 1)) {
                str.append(str1.charAt(i - 1));
                i--;
                j--;
                k--;
            } else {
                if (dp[i - 1][j][k] >= dp[i][j - 1][k] && dp[i - 1][j][k] >= dp[i][j][k - 1]) {
                    i--;
                } else if (dp[i][j - 1][k] >= dp[i - 1][j][k] && dp[i][j - 1][k] >= dp[i][j][k - 1]) {
                    j--;
                } else {
                    k--;
                }
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        String virus = sc.next();

        int n = str1.length();
        int m = str2.length();
        int l = virus.length();

        System.out.println(lcs(str1, n, str2, m, virus, l));
    }
}
