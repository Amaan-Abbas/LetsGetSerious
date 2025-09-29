package basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapping {
    public static void main(String[] args) {
        Map<Integer, Integer> mpp = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            System.out.println(mpp.getOrDefault(num, 0));
            System.out.println(mpp.entrySet());
        }

        sc.close();


    }
}
