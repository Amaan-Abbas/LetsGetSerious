package basics;

import java.util.Scanner;

public class FindSum {

    public static int sum(int val, int seq) {
        int sum = 0;
        for (int i = 0; i < seq; i++) {
            sum += val;
            val *= -1;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] result = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            int val = sc.nextInt();
            int seq = sc.nextInt();

            result[i] = sum(val, seq);
        }

        sc.close();

        for (int i = 0; i < testCase; i++) {
            System.out.println(result[i]);
        }
    }
}
