package digitDP;

import java.util.*;

public class DigitDpTemplate {

    static String num;
    static int n;

    // ---------------------------------------------------------------
    // memo[pos][tight][leadingZero][...extra states...]
    // Adjust the extra dimensions based on the problem.
    //
    // Here: memo[pos][tight][leadingZero]
    //   pos         : current index in the digit string (0 to n-1)
    //   tight       : 1 if current prefix == prefix of N, 0 if already smaller
    //   leadingZero : 1 if no non-zero digit placed yet
    //
    // Replace `long` with `int` if counts fit in int.
    // ---------------------------------------------------------------
    static long[][][] memo;

    // ---------------------------------------------------------------
    // solve(pos, tight, leadingZero)
    //
    // Returns: count (or sum, or whatever the problem asks) of valid
    //          numbers formed by filling positions [pos, n-1].
    // ---------------------------------------------------------------
    static long solve(int pos, int tight, int leadingZero) {

        // Base case: all digits placed
        if (pos == n) {
            // leadingZero == 1 means the number is 0 (only leading zeros placed)
            // Adjust this condition based on whether 0 is a valid answer
            if (leadingZero == 1) return 0;
            return 1; // ← change to return accumulated value if doing sum
        }

        // Return cached result
        if (memo[pos][tight][leadingZero] != -1)
            return memo[pos][tight][leadingZero];

        // Maximum digit we can place at this position
        int limit = tight == 1 ? (num.charAt(pos) - '0') : 9;

        long result = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int newTight      = (tight == 1 && digit == limit) ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 && digit == 0) ? 1 : 0;

            // ── Add your problem-specific state transitions here ──
            // Example: tracking digit sum mod K
            //   pass (currentSum + digit) % K as an extra parameter
            //
            // Example: tracking last digit for adjacency checks
            //   pass digit as lastDigit when newLeadingZero == 0

            result += solve(pos + 1, newTight, newLeadingZero);
        }

        return memo[pos][tight][leadingZero] = result;
    }

    // ---------------------------------------------------------------
    // count(x) : count valid numbers in [0, x]
    // ---------------------------------------------------------------
    static long count(long x) {
        if (x < 0) return 0;
        num = Long.toString(x);
        n   = num.length();

        // Initialise memo — adjust dimensions for extra states
        memo = new long[n][2][2];
        for (long[][] a : memo)
            for (long[] b : a)
                Arrays.fill(b, -1L);

        return solve(0, 1, 1);
    }

    // ---------------------------------------------------------------
    // Range query [L, R]
    // ---------------------------------------------------------------
    static long query(long L, long R) {
        return count(R) - count(L - 1);
    }

    // ---------------------------------------------------------------
    // Main — replace with Scanner for competitive input
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        long L = 1, R = 100;
        System.out.println("Count in [" + L + ", " + R + "] = " + query(L, R));
    }
}