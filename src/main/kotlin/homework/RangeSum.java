//package homework;

import java.util.Scanner;

public class RangeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] nums = new long[n + 1];
        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextLong();
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int j = 0; j < q; j++) {
            int l = sc.nextInt();
            int u = sc.nextInt();

            long sum = prefix[u] - prefix[l - 1];
            System.out.println(sum);
        }
    }
}
