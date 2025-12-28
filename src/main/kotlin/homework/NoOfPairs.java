package homework;

import java.util.Arrays;
import java.util.Scanner;

public class NoOfPairs {
    public static int noOfPairs(int n, int l, int r, int[] pairs) {
        if (n == 1) return 0;
        if (n == 2) {
            int sum = pairs[0] + pairs[1];
            return (sum >= l && sum <= r) ? 1 : 0;
        }

        Arrays.sort(pairs);

        int i = 0, j = n - 1, count = 0;

        while (i < j) {
            int sum = pairs[i] + pairs[j];

            if (sum >= l && sum <= r) {
                i++;
                count++;
            } else if (sum < l) {
                i++;
            }
            else {
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            int[] pairs = new int[n];
            for (int j = 0; j < n; j++) pairs[j] = sc.nextInt();

            System.out.println(noOfPairs(n, l, r, pairs));
        }
    }
}
