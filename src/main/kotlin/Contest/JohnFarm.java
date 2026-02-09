package Contest;

import java.util.Scanner;

public class JohnFarm {
    public static int combination(int legs) {
        int count = 0;
        while (legs > 0) {
            if (legs - 2 >= 0) {
                count++;
                legs -= 2;
            }

            if (legs - 4 >= 0) {
                count++;
                legs -= 4;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int legs = sc.nextInt();

            if (legs % 2 == 0) {
                int ans = combination(legs);
                System.out.println(ans);
            } else System.out.println(0);
        }
    }
}
