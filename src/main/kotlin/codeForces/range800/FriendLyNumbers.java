package codeForces.range800;

import java.util.Scanner;

public class FriendLyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int num = scanner.nextInt();
            int countNumbers = 0;

            for (int i = num; i <= num + 90; i++) {
                if (i - calculateSum(i) == num)
                    countNumbers++;
            }

            sb.append(countNumbers).append("\n");
        }

        System.out.println(sb);
    }

    public static int calculateSum(int num) {
        int sum = 0;

        while (num != 0) {
            int d = num % 10;
            sum += d;
            num /= 10;
        }

        return sum;
    }
}
