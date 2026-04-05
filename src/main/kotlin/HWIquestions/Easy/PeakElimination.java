package HWIquestions.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class PeakElimination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            list.add(arr[i]);
        }

        int count = 0;
        boolean peakFound = true;

        while (peakFound) {
            peakFound = false;

            for (int i = 1; i < list.size() - 1; i++) {

                if (list.get(i) > list.get(i + 1) && list.get(i) > list.get(i - 1)) {

                    list.remove(i);
                    count++;
                    peakFound = true;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
