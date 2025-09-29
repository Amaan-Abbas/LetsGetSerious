package bitManipulation;

public class BitWise {
    public static int evenNumberBitwiseORs(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 0) {
                res |= nums[i];
            }
        }

        if (res != 0) return res;
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 16};
        System.out.println(evenNumberBitwiseORs(arr));
    }
}
