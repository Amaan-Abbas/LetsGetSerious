package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashingNumbers {
    public static List<List<Integer>> countFrequencies(int[] arr) {

        List<List<Integer>> lol = new ArrayList<>();

        int size = arr.length;
        boolean[] traversed = new boolean[size];

        for (int  i = 0; i < size; i++) {
            if (traversed[i]) continue;

            int count = 1;
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    traversed[j] = true;
                    count++;
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(count);

            lol.add(list);
        }

        return lol;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2};

        List<List<Integer>> list = countFrequencies(arr);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
