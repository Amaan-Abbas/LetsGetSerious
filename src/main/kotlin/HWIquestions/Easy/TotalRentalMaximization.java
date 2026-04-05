package HWIquestions.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class TotalRentalMaximization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] customers = new int[n];
        for (int i = 0; i < n; i++)
            customers[i] = sc.nextInt();

        int[] ratings = new int[m];
        for (int i = 0; i < m; i++)
            ratings[i] = sc.nextInt();


        Arrays.sort(customers);
        Arrays.sort(ratings);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            if (customers[i] <= ratings[j]) {
                count++;
                j++;
                i++;
            } else if (k > 0 && customers[i] <= (ratings[j] * 2)) {
                count++;
                k--;
                j++;
                i++;
            } else j++;
        }

        System.out.println(count);
    }
}
