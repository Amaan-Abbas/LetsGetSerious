package basics;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        if (isArmstrong(n)) System.out.println("It is an Armstrong number.");
        else System.out.println("It is not am Armstrong number.");
    }

    public static boolean isArmstrong(int n) {
        int copy = n;
        int arm = 0;

        while (copy != 0) {
            int d = (int) Math.pow(copy % 10, 3);
            arm += d;
            copy /= 10;
        }

        return arm == n;
    }
}
