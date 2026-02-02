package digitDP;

import java.util.Scanner;

// recursive approach
//public class CountingNumber {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long a, b;
//        a = scanner.nextLong();
//        b = scanner.nextLong();
//
//        String l = String.valueOf(a - 1);
//        String r = String.valueOf(b);
//
//        long ans = solve(r, 0, 1, 10, 1) - solve(l, 0, 1, 10, 1);
//        System.out.println(ans);
//    }
//
//    public static long solve(String s, int idx, int tight, int prev, int leadingZero) {
//        if (idx == s.length()) return 1;
//
//        int lb = 0;
//        int ub  = (tight == 1) ? s.charAt(idx) - '0' : 9;
//        long result = 0;
//
//        for (int digit = lb; digit <= ub; digit++) {
//            if (leadingZero == 0 && digit == prev) continue;
//
//            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
//            int newLeadingZero = (leadingZero == 1 && digit == 0) ? 1 : 0;
//            result += solve(s, idx + 1, newTight, digit, newLeadingZero);
//        }
//
//        return result;
//    }
//}



// Now using memoization.
public class CountingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a, b;
        a = scanner.nextLong();
        b = scanner.nextLong();

        String l = String.valueOf(a - 1);
        String r = String.valueOf(b);

        Long[][][][] dp1 = new Long[20][2][11][2]; // memoized dp for right number
        Long[][][][] dp2 = new Long[20][2][11][2]; // memoized dp for left number

        long ans = solve(r, 0, 1, 10, 1, dp1) - solve(l, 0, 1, 10, 1, dp2);
        System.out.println(ans);
    }

    public static long solve(String s, int idx, int tight, int prev, int leadingZero, Long[][][][] dp) {
        if (idx == s.length()) return 1;

        if (dp[idx][tight][prev][leadingZero] != null) return dp[idx][tight][prev][leadingZero];

        int lb = 0;
        int ub  = (tight == 1) ? s.charAt(idx) - '0' : 9;
        long result = 0;

        for (int digit = lb; digit <= ub; digit++) {
            if (leadingZero == 0 && digit == prev) continue;

            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 && digit == 0) ? 1 : 0;
            result += solve(s, idx + 1, newTight, digit, newLeadingZero, dp);
        }

        return dp[idx][tight][prev][leadingZero] = result;
    }
}

