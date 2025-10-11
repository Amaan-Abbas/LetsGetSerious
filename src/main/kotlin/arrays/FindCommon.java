package arrays;

import java.util.HashMap;
import java.util.Map;

public class FindCommon {

    public static void main(String[] args) {
        int answer1 = 0;
        int answer2 = 0;

        int[] arr = {2, 3, 2};
        int[] arr2 = {1, 2};

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : arr2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

//        for (Map<Integer, Integer> Map) {
//            if (map2.containsKey(i)) {
//                answer1 = i
//            }
//        }


    }
}
