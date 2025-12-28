package homework;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void towerOfHanoi(int a, int b, int c, int disk, int count) {
        if (disk == 0) return;

        towerOfHanoi(a, c, b, disk - 1, count + 1);
        System.out.println(a + " " + b);
        towerOfHanoi(c, b, a, disk - 1, count + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println((int)Math.pow(2.0, n) - 1);
        towerOfHanoi(1, 3, 2, n, 0);
    }
}
