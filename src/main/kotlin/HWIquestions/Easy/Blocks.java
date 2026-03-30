package HWIquestions.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class Blocks {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] oneBlock = new int[n];
        int[] zeroBlock = new int[n];

        for (int i = 0; i < n; i++)
            oneBlock[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            zeroBlock[i] = sc.nextInt();

        Arrays.sort(oneBlock);

        for (int i = 0; i < n / 2; i++) {
            int temp = oneBlock[i];
            oneBlock[i] = oneBlock[n - 1 - i];
            oneBlock[n - 1 - i] = temp;
        }

        Arrays.sort(zeroBlock);

        StringBuilder str = new StringBuilder();
        int i = 0, j = 0, chance = 0;

        while (i < n || j < n) {

            if (chance % 2 == 0) {
                String toAdd = "1".repeat(oneBlock[i++]);
                str.append(toAdd);
                chance++;
            } else {
                String toAdd = "0".repeat(zeroBlock[j++]);
                str.append(toAdd);
                chance++;
            }
        }

        int num = 0;
        for (i = str.length() - 1; i >= 0; i--) {
            num += ((str.charAt(i) - '0') * (int) Math.pow(2, str.length() - 1 - i)) % MOD;
        }

        num %= MOD;
        System.out.println(num);
    }
}
