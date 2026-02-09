package homework;

public class SumOfDie {
    public static int possibleCombinations(int[] arr, int idx, int sum, int target, int count) {
        if (idx == arr.length) return 0;
        if (sum == target) return count + 1;

        int notTake = possibleCombinations(arr, idx, sum + arr[idx], target, count);

        int take = 0;
        if (sum < target) {
            take = possibleCombinations(arr, idx + 1, sum + arr[idx], target, count);
        }

        return Math.max(notTake, take);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 3;

        System.out.println(possibleCombinations(nums, 0, 0, target, 0));
    }
}
