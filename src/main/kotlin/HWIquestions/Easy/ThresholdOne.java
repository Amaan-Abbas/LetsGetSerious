package HWIquestions.Easy;

import java.util.Scanner;

public class ThresholdOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int powerUp = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1] + x)
                index = i;
            else {
                if (powerUp > 0) {
                    powerUp--;
                    index = i;
                } else
                    break;
            }
        }

        System.out.println(index);
    }
}
