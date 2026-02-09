package homework;

public class SubarraySum {
    public static int subarraySum(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = 0, sum = 0;
        int count = 0;

        while (i < n) {
            sum += nums[j];
            if (sum == target) {
                count++;
                i++;
                j = i;
                sum = 0;
            } else if (sum > target) {
                i++;
                j = i;
                sum = 0;
            }

            if (j == n) {
                i++;
                j = i;
            }

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 7};
        System.out.println(subarraySum(nums, 7));
    }
}
