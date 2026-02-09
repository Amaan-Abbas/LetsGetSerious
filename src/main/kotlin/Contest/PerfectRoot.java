package Contest;

import java.util.Scanner;

public class PerfectRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            for (int j = 1; j <= num; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
