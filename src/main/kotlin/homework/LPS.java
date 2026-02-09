//package homework;

//import java.util.Scanner;
//
//class LPS {
//    public static String lpc(String ch1, int n, String ch2) {
//        int[][] dp = new int[n + 1][n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (ch1.charAt(i - 1) == ch2.charAt(j - 1)) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//
//        int i = n, j = n;
//        StringBuilder ansBuilder = new StringBuilder();
//        while (i > 0 && j > 0) {
//            if (ch1.charAt(i - 1) == ch2.charAt(j -1)) {
//                ansBuilder.insert(0, ch1.charAt(i - 1));
//                i--;
//                j--;
//            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
//            else j--;
//        }
//         return ansBuilder.toString();
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String str = sc.next();
//        int n = str.length();
//        String rev = new StringBuilder(str).reverse().toString();
//
//        System.out.println(lpc(str, n, rev));
//    }
//}



//package homework;

import java.util.Scanner;

class LPS {
    public static String lpc(String ch1, int n, String ch2, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (ch1.charAt(i - 1) == ch2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder ansBuilder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (ch1.charAt(i - 1) == ch2.charAt(j -1)) {
                ansBuilder.insert(0, ch1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }
        return ansBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = str.length();

        String st = sc.next();
        int m = st.length();

        System.out.println(lpc(str, n, st, m));
    }
}
