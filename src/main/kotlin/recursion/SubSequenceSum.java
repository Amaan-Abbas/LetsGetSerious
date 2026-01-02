package recursion;

import java.util.ArrayList;

public class SubSequenceSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 1, 3};
        helper(arr, 0, 0, 5, new ArrayList<>());
    }

    public static void helper(int[] arr, int idx, int sum, int k, ArrayList<Integer> curr) {
        if (idx == arr.length) {
            if (sum == k) {
                System.out.println(curr);
            }
            return;
        }

        // Take
        curr.add(arr[idx]);
        helper(arr, idx + 1, sum + arr[idx], k, curr);

        // Not take
        curr.removeLast();
        helper(arr, idx + 1, sum, k, curr);

    }
}
