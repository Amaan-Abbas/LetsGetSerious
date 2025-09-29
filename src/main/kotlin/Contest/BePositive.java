package Contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BePositive {

    //function to return the number of min steps required to get the positive product
    public static int count(Map<Integer, Integer> arr) {
        int count = 0;
        for (Map.Entry<Integer, Integer> mpp: arr.entrySet()) {
            if (mpp.getKey() == -1) {
                int checkEven = mpp.getValue()%2;
                count += 2*checkEven; //returns the number of left odd -1 in the array
            } else if (mpp.getKey() == 0) {
                count += mpp.getValue(); // returns the number of 0's in the array
            } // no operation for 1's
        }

        return count;
    }

    // function to map the array to find the value frequency pair in the array
    public static Map<Integer, Integer> mapConversion(int size, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        // maps the value and frequency of the array
        for (int i = 0; i < size; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return map;
    }

    //function to take input for the array
    public static int[] inputArray(int size, Scanner scanner) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int size = scanner.nextInt();

            int[] arr = inputArray(size, scanner);
            Map<Integer, Integer> map = mapConversion(size, arr);

            int count = count(map);
            System.out.println(count);
        }

        scanner.close();
    }
}
