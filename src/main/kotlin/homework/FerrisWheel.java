package homework;

import java.util.Arrays;
import java.util.Scanner;

public class FerrisWheel {
    public static int noOfGondolas(int n, int capacity, int[] weight) {
        if (n == 1 && weight[0] <= capacity) return 1;

        Arrays.sort(weight);

        int i = 0, j = n - 1, count = 0;

        while (i <= j) {
            int sum = weight[i] + weight[j];

            if (sum <= capacity) i++;

            j--;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int capacity = sc.nextInt();

        int[] weight = new int[n];
        for (int i = 0; i < n; i++) weight[i] = sc.nextInt();

        System.out.println(noOfGondolas(n, capacity, weight));
    }
}
