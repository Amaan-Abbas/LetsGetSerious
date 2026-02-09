package Contest;

import java.util.Scanner;

public class PerfectMax {
    public static long compareSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int x : arr) {
            max = Math.max(max, x);
            sum += max;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            long bestValue = compareSum(arr);

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int[] temp = arr.clone();
                    int swap = temp[i];
                    temp[i] = temp[j];
                    temp[j] = swap;

                    bestValue = Math.max(bestValue, compareSum(temp));
                }
            }

            System.out.println(bestValue);
        }

        sc.close();
    }
}
