package arrays;

import java.util.Scanner;

public class SolutionToWork {
    public static int count(int[][] arr) {
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            int check = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 1) check++;
            }

            if (check >= 2) val++;
        }

        return val;
    }

    public static void main(String[] args) {
        int agree = 0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(count(arr));
    }
}
